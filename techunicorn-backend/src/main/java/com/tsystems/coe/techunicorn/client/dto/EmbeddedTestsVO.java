package com.tsystems.coe.techunicorn.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmbeddedTests VO Class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedTestsVO {

	private List<TestVO> tests;

}
