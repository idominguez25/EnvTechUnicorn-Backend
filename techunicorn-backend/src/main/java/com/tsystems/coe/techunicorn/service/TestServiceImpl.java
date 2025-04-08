package com.tsystems.coe.techunicorn.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsystems.coe.techunicorn.client.DevSkillerClient;
import com.tsystems.coe.techunicorn.client.dto.GetTestsVO;
import com.tsystems.coe.techunicorn.client.dto.TestVO;
import com.tsystems.coe.techunicorn.domain.Test;
import com.tsystems.coe.techunicorn.dto.TestDTO;
import com.tsystems.coe.techunicorn.mapper.TestFeignMapper;
import com.tsystems.coe.techunicorn.repository.TestRepository;

import lombok.extern.log4j.Log4j2;

/**
 * Test Service implementation.
 */
@Service
@Log4j2
public class TestServiceImpl extends AbstractCrudService<Test, Long, TestRepository, TestDTO> implements TestService {

	@Autowired
	private DevSkillerClient devSkillerClient;

	@Autowired
	private TestFeignMapper feignMapper;

	@Override
	public void sync() {
		log.info("Tests sync() process invoked.");

		// 1. Gather the tests from the provider.
		GetTestsVO tests = this.devSkillerClient.getTests();

		// 2. Iterate the DB tests and remove the outdated ones.
		List<String> providerIds = tests.get_embedded().getTests().stream().map(TestVO::getId)
				.collect(Collectors.toList());
		for (Test test : repository.findAll()) {
			if (!providerIds.contains(test.getProviderId())) {
				repository.delete(test);
			}
		}

		// 3. Iterate the tests and store the new ones.
		for (TestVO testVo : tests.get_embedded().getTests()) {
			if (!repository.findByProviderId(testVo.getId()).isPresent()) {
				repository.save(feignMapper.dtoToDomain(testVo));
			}
		}
	}

	@Override
	public List<Test> findTestBySkillsNameIgnoreCase(String skill) {
		return repository.findTestBySkillsNameIgnoreCase(skill);

	}

	@Override
	public Test findByProviderId(String providerId) {
		Optional<Test> test = this.repository.findByProviderId(providerId);
		if (test.isPresent()) {
			return test.get();
		} else {
			return null;
		}
	}

}
