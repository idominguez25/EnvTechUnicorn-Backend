package com.tsystems.coe.techunicorn.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tsystems.coe.techunicorn.domain.Test;

/**
 * Test repository.
 */
@Repository
public interface TestRepository extends BaseRepository<Test, Long> {

	/**
	 * Gathers a test by its provider id.
	 * 
	 * @param providerId The provider id.
	 * @return An instance of {@link Test}.
	 */
	Optional<Test> findByProviderId(final String providerId);

	/**
	 * Gather a list of tests by its skill.
	 * 
	 * @param skill The name of the skill we want to search for.
	 * @return A list of tests that contain the skill we are looking for.
	 */
	List<Test> findTestBySkillsNameIgnoreCase(String skill);

}