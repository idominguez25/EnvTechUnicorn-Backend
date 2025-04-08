package com.tsystems.coe.techunicorn.client.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AssessmentType Class.
 */
@AllArgsConstructor
@Getter
public enum AssessmentType {
	CHOICE("CHOICE"), CODE_GAPS("CODE GAPS"), CODE_REVIEW("CODE REVIEW"), DATABASE("DATABASE"), DEVOPS("DEVOPS"),
	ESSAY("ESSAY"), PROGRAMMING("PROGRAMMING"), TESTING("TESTING");

	private String reasonPhrase;
}