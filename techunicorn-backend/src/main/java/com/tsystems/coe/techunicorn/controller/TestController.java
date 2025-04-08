package com.tsystems.coe.techunicorn.controller;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.coe.techunicorn.dto.TestDTO;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

/**
 * Test REST Controller.
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Controller for Tests management.")
@RequestMapping("/tests")
public class TestController extends AbstractCrudController<TestDTO, Long> {
	@Override
	public ResponseEntity<TestDTO> create(TestDTO dto) {
		throw new NotImplementedException();
	}

	@Override
	public ResponseEntity<TestDTO> update(TestDTO dto) {
		throw new NotImplementedException();
	}

	@Override
	public void delete(Long id) {
		throw new NotImplementedException();
	}

}
