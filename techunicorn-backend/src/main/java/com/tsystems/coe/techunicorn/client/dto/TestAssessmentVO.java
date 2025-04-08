package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TestAssessment VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestAssessmentVO {

	private String id;
	private String name;
	private LinkSelfVO _links;

}
