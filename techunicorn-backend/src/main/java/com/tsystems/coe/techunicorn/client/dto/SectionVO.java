package com.tsystems.coe.techunicorn.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Section VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SectionVO {

	private int timeTakenInSeconds;
	private int timeLimitInSeconds;
	private ScoreVO score;
	private List<AnswerVO> answers;

}
