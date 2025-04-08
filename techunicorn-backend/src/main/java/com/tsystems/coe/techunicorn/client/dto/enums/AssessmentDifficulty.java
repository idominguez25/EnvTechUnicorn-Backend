package com.tsystems.coe.techunicorn.client.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AssessmentDifficulty Class.
 */
@AllArgsConstructor
@Getter
public enum AssessmentDifficulty {
	EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");

	private String reasonPhrase;
}
