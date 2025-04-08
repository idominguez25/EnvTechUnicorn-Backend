package com.tsystems.coe.techunicorn.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tsystems.coe.techunicorn.domain.Candidate;

/**
 * Candidate repository.
 */
@Repository
public interface CandidateRepository extends BaseRepository<Candidate, Long> {

	/**
	 * Gathers a candidate by its provider id.
	 * 
	 * @param providerId The provider id.
	 * @return An instance of {@link Candidate}.
	 */
	Optional<Candidate> findByProviderId(final String providerId);

}
