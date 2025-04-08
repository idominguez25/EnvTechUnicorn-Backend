package com.tsystems.coe.techunicorn.service;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.coe.techunicorn.client.DevSkillerClient;
import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.client.dto.CandidateVO;
import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;
import com.tsystems.coe.techunicorn.domain.Assessment;
import com.tsystems.coe.techunicorn.domain.Candidate;
import com.tsystems.coe.techunicorn.dto.AssessmentDTO;
import com.tsystems.coe.techunicorn.mapper.AssessmentFeignMapper;
import com.tsystems.coe.techunicorn.repository.AssessmentRepository;
import com.tsystems.coe.techunicorn.repository.CandidateRepository;

import feign.FeignException;
import lombok.extern.log4j.Log4j2;

/**
 * Assessment Service implementation.
 */
@Service
@Log4j2
public class AssessmentServiceImpl extends AbstractCrudService<Assessment, Long, AssessmentRepository, AssessmentDTO>
		implements AssessmentService {

	@Autowired
	private DevSkillerClient devSkillerClient;

	@Autowired
	private AssessmentFeignMapper assessmentMapper;

	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public void checkPending() {
		log.info("checkPending()");

		// 1. Gather the pending assessments.
		List<Assessment> assessments = this.repository.findByStatusIn(Arrays.asList(AssessmentStatus.NEW,
				AssessmentStatus.TOKEN_SENT, AssessmentStatus.TEST_STARTED, AssessmentStatus.AUTO_ASSESSMENT_READY));

		// 2. For each assessment, check its current status in the provider.

		for (Assessment assessment : assessments) {
			// Invoke the provider by using the provider ids.

			AssessmentVO assessmentVo = devSkillerClient.getAssessment(assessment.getCandidate().getProviderId(),
					assessment.getProviderId());

			// Check the provider assessment for changes in the status.

			if (!StringUtils.equals(assessment.getStatus().getId(), assessmentVo.getStatus().getId())) {
				log.info("Assessment {} status has changed ({} -> {}) and will be updated.", assessment.getId(),
						assessment.getStatus(), assessmentVo.getStatus());

				// The status has changed. Update and persist the assessment.

				assessment.setStatus(assessmentVo.getStatus());
				assessment.setFinishDate(assessmentVo.getFinishDate());
				assessment.setMaxPoints(assessmentVo.getScore().getMaxPoints());
				assessment.setPercentage(assessmentVo.getScore().getPercentage());
				assessment.setScoredPoints(assessmentVo.getScore().getScoredPoints());
				assessment.setStartDate(assessmentVo.getStartDate());
				assessment.setTimeLimitInSeconds(assessmentVo.getTimeLimitInSeconds());
				assessment.setTimeTakenInSeconds(assessmentVo.getTimeTakenInSeconds());
				this.repository.save(assessment, assessment.getVersion());

				// Notify the application user.
				// TODO.

			}

		}

	}

	@Override
	public void prune() {
		// TODO Auto-generated method stub

	}

	@Override
	public AssessmentDTO create(AssessmentVO assessmentVO, Candidate candidate) {
		Assessment assessment = this.assessmentMapper.dtoToDomain(assessmentVO);
		assessment.setCandidate(candidate);
		return this.mapper.domainToDto(this.repository.save(assessment));
	}

	@Override
	public void sync(final Candidate candidate) {
		log.info("Assessment sync. Candidate {}.", candidate);

		// 1. Gather the candidate from the provider - which contains the assessments.
		CandidateVO candidateVo = this.devSkillerClient.getCandidate(candidate.getProviderId());

		// 2. Iterate the assessments and create the new ones in the DB.
		if (candidateVo.get_embedded().getAssessments() != null) {
			for (AssessmentVO assessmentVo : candidateVo.get_embedded().getAssessments()) {
				if (!this.repository.findByProviderId(assessmentVo.getId()).isPresent()) {
					try {
						// Gather the assessment data.
						assessmentVo = this.devSkillerClient.getAssessment(candidate.getProviderId(),
								assessmentVo.getId());
					} catch (FeignException e) {
						log.info("Assessment {} could not be gathered.", assessmentVo);
					}

					// Create and add the assessment to the candidate.
					Assessment assessment = this.assessmentMapper.dtoToDomain(assessmentVo);
					assessment.setCandidate(candidate);

					this.repository.save(assessment);
				}
			}
		}

	}

}
