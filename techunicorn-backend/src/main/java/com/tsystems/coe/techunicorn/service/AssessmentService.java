package com.tsystems.coe.techunicorn.service;

import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.common.Transactional;
import com.tsystems.coe.techunicorn.domain.Candidate;
import com.tsystems.coe.techunicorn.dto.AssessmentDTO;

/**
 * Assessment Service interface.
 */
public interface AssessmentService extends CrudService<AssessmentDTO, Long> {

	/**
	 * Checks the pending assessments for new results or expirations.
	 */
	void checkPending();

	/**
	 * Prunes the old assessments.
	 */
	void prune();

	/**
	 * Performs a synchronization of the assessments of a candidate, identified by
	 * its provider id. If any assessment is created, it will be linked to the
	 * candidate.
	 * 
	 * @param candidate The candidate instance.
	 */
	@Transactional
	void sync(final Candidate candidate);

	/**
	 * Creates an assessment given a provider assessment instance.
	 * 
	 * @param assessmentVO Instance of the provider Assessment object.
	 * @param candidate    Candidate instance whose assessment is to be stored.
	 * @return Persisted Assessment DTO instance.
	 */
	@Transactional
	AssessmentDTO create(final AssessmentVO assessmentVO, final Candidate candidate);

}
