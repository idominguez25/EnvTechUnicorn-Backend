package com.tsystems.coe.techunicorn.service;

import java.util.List;

import com.tsystems.coe.techunicorn.common.Transactional;
import com.tsystems.coe.techunicorn.domain.Test;
import com.tsystems.coe.techunicorn.dto.TestDTO;

/**
 * Test Service interface.
 */
public interface TestService extends CrudService<TestDTO, Long> {

	/**
	 * Performs an on-demand synchronization of the tests stored in the provider.
	 */
	@Transactional
	void sync();

	/**
	 * Gathers a test by its provider id.
	 * 
	 * @param providerId The provider id.
	 * @return An instance of {@link Test}.
	 */
	Test findByProviderId(final String providerId);

	/**
	 * Gather a list of tests by its skill.
	 * 
	 * @param skill The name of the skill we want to search for.
	 * @return A list of tests that contain the skill we are looking for.
	 */
	List<Test> findTestBySkillsNameIgnoreCase(String skill);

}
