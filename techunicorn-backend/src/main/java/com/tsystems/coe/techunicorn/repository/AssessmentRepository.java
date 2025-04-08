package com.tsystems.coe.techunicorn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;
import com.tsystems.coe.techunicorn.domain.Assessment;

/**
 * Assessment repository.
 */
@Repository
public interface AssessmentRepository extends BaseRepository<Assessment, Long> {

	/**
	 * Gathers the assessments whose status match any entry of the given list.
	 * 
	 * @param status List of statuses to search.
	 * @return List of assessments filtered by their status.
	 */
	List<Assessment> findByStatusIn(final List<AssessmentStatus> status);

	/**
	 * Gathers an assessment by its provider id.
	 * 
	 * @param providerId The provider id.
	 * @return An instance of {@link Assessment}.
	 */
	Optional<Assessment> findByProviderId(final String providerId);

}
