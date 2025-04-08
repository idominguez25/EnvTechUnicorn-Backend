package com.tsystems.coe.techunicorn.client.dto;

import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentDifficulty;
import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Answer VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerVO {

	private String taskId;
	private String title;
	private String gitUrl;
	private AssessmentType type;
	private AssessmentDifficulty difficulty;
	private ScoreVO score;
}
