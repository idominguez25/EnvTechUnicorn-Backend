package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Score VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScoreVO {

	private int scoredPoints;
	private int maxPoints;
	private int percentage;

}
