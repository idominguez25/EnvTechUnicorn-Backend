package com.tsystems.coe.techunicorn.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationErrorCode {
	OPTIMISTIC_LOCK_ERROR("Optimistic lock - A new version of the information is available."),
	TECHNICAL_ERROR("An unhandled error has occurred.");

	private String reasonPhrase;
}
