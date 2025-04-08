package com.tsystems.coe.techunicorn.service;

import com.tsystems.coe.techunicorn.common.Transactional;
import com.tsystems.coe.techunicorn.dto.CandidateDTO;
import com.tsystems.coe.techunicorn.dto.SkillDTO;

/**
 * Candidate Service interface.
 */
public interface CandidateService extends CrudService<CandidateDTO, Long> {

	/**
	 * Performs an on-demand synchronization of the candidates stored in the
	 * provider.
	 */
	@Transactional
	void sync();

	/**
	 * Prunes the old candidates.
	 */
	void prune();

	/**
	 * Sends an exam invitation to the candidate for the given test.
	 * 
	 * @param candidateDto Candidate information.
	 * @param testId       Test identifier (provider's).
	 */
	void inviteCandidate(final CandidateDTO candidateDto, final Long testId);

	/**
	 * Sends an exam invitation to the candidate for a test for the provided skill.
	 * 
	 * @param candidateDto Candidate information.
	 * @param skillDto     Skill used to find a test.
	 */
	void inviteCandidateBySkill(final CandidateDTO candidateDto, final SkillDTO skillDto);

}
