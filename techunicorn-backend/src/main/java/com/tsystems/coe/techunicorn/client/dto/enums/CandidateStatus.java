package com.tsystems.coe.techunicorn.client.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * CandidateStatus Class.
 */
@Getter
@AllArgsConstructor

public enum CandidateStatus {
	NEW("NEW"), WAITING_FOR_ANSWERS("WAITING FOR ANSWERS"), IN_EVALUATION("IN EVALUATION"),
	WAITING_FOR_DECISION("WAITING FOR DECISION"), ACCEPTED("ACCEPTED"), REJECTED("REJECTED"), EXPIRED("EXPIRED"),
	CANCELED("CANCELED"), ERROR("ERROR");

	private String reasonPhrase;
}
