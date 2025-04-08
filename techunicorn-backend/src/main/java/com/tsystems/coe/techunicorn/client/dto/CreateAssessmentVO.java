package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateAssessment VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAssessmentVO {

	private String testId;
	private int validityInDays;
	private String note;

}
