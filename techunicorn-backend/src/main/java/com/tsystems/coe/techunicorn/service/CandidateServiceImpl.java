package com.tsystems.coe.techunicorn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.coe.techunicorn.client.DevSkillerClient;
import com.tsystems.coe.techunicorn.client.dto.CandidateVO;
import com.tsystems.coe.techunicorn.client.dto.CreateCandidateVO;
import com.tsystems.coe.techunicorn.client.dto.CreateInvitationVO;
import com.tsystems.coe.techunicorn.client.dto.GetCandidatesVO;
import com.tsystems.coe.techunicorn.client.dto.InvitationVO;
import com.tsystems.coe.techunicorn.common.Transactional;
import com.tsystems.coe.techunicorn.domain.Candidate;
import com.tsystems.coe.techunicorn.domain.Test;
import com.tsystems.coe.techunicorn.dto.CandidateDTO;
import com.tsystems.coe.techunicorn.dto.SkillDTO;
import com.tsystems.coe.techunicorn.exception.EntityNotFoundException;
import com.tsystems.coe.techunicorn.mapper.CandidateFeignMapper;
import com.tsystems.coe.techunicorn.repository.CandidateRepository;

import lombok.extern.log4j.Log4j2;

/**
 * Candidate Service implementation.
 */
@Service
@Log4j2
public class CandidateServiceImpl extends AbstractCrudService<Candidate, Long, CandidateRepository, CandidateDTO>
		implements CandidateService {

	@Autowired
	private DevSkillerClient devSkillerClient;

	@Autowired
	private TestService testService;

	@Autowired
	private CandidateFeignMapper feignMapper;

	@Autowired
	private AssessmentService assessmentService;

	@Override
	public void sync() {
		log.info("Candidates sync() process invoked.");

		this.syncPaged(0);
	}

	@Transactional
	private void syncPaged(int page) {
		log.info("Candidates syncPaged({}) process invoked.", page);

		// 1. Gather the candidates from the provider.
		GetCandidatesVO candidates = this.devSkillerClient.getCandidates(page);

		// 2. Iterate the DB candidates and soft-delete the outdated ones.
		List<String> providerIds = candidates.get_embedded().getCandidates().stream().map(CandidateVO::getId)
				.collect(Collectors.toList());
		for (Candidate candidate : this.repository.findAll()) {
			if (!providerIds.contains(candidate.getProviderId())) {
				this.softDelete(candidate.getId());
			}
		}

		// 3. Iterate the provider candidates and store the new ones.
		for (CandidateVO candidateVo : candidates.get_embedded().getCandidates()) {
			if (!this.repository.findByProviderId(candidateVo.getId()).isPresent()) {
				Candidate candidate = this.repository.save(feignMapper.dtoToDomain(candidateVo));

				// Sync the candidate assessments.
				this.assessmentService.sync(candidate);
			}
		}

		// 4. If further pages are available, proceed with the next one.
		if (candidates.getPage().getTotalPages() - 1 > page) {
			this.syncPaged(++page);
		}

	}

	@Override
	public void inviteCandidateBySkill(final CandidateDTO candidateDto, final SkillDTO skillDto) {
		// Preconditions.
		// 1. Sync the tests (provider -> DB).
		testService.sync();

		// Find a test given its main skill.
		List<Test> list = this.testService.findTestBySkillsNameIgnoreCase(skillDto.getName());

		// If no test is found, throw an exception.
		if (list == null || list.isEmpty()) {
			throw new EntityNotFoundException(skillDto);
		}

		// Invite the candidate using the test id.
		this.inviteCandidate(candidateDto, list.get(0).getId());
	}

	@Override
	public void inviteCandidate(final CandidateDTO candidateDto, final Long testId) {
		log.info("inviteCandidate. Candidate: {}, testId: {}", candidateDto, testId);

		// Preconditions.
		// 1. Sync the tests (provider -> DB).
		testService.sync();
		// 2. Check the test id does exist.
		if (!testService.exists(testId)) {
			throw new EntityNotFoundException(testId);
		}

		// Main process.
		// 1. Sync the candidates from the provider.
		this.sync();

		// 2. Gather the candidates by using the provided e-mail.
		GetCandidatesVO candidates = this.devSkillerClient.findCandidates(String.valueOf(candidateDto.getEmail()));

		// 3. Check whether the candidate exists in the provider.
		if (candidates.get_embedded() == null) {
			// The candidate does not exist. Create in the provider.
			// Only e-mail is sent to the provider, no personal data is handled.
			CreateCandidateVO createCandidate = new CreateCandidateVO(candidateDto.getEmail(), null, null, null, null,
					false);
			CandidateVO candidateVO = this.devSkillerClient.createCandidate(createCandidate);

			// Persist in the database.
			candidateDto.setProviderId(candidateVO.getId());
			this.repository.save(this.mapper.dtoToDomain(candidateDto));
		}

		// 4. Send the invitation.
		CreateInvitationVO createInvitation = CreateInvitationVO.builder().email(candidateDto.getEmail())
				.testId(testService.getById(testId).getProviderId()).validityInDays(2).note("").build(); // TODO:
																											// Validity
																											// must be
																											// Configurable!!!
		InvitationVO invitation = this.devSkillerClient.createInvitation(createInvitation);

		// 5. Update the candidate status.
		Optional<Candidate> candidate = this.repository
				.findByProviderId(invitation.get_embedded().getCandidate().getId());
		Candidate candidateMdf = candidate.get();
		candidateMdf.setStatus(invitation.get_embedded().getCandidate().getStatus());
		if (candidateMdf.getAssessments() == null) {
			candidateMdf.setAssessments(new ArrayList<>());
		}
		this.repository.save(candidateMdf);

		// 6. Create the assessment.
		this.assessmentService.create(invitation.get_embedded().getAssessment(), candidateMdf);

	}

	@Override
	public void prune() {
		// TODO Auto-generated method stub

	}

}