package com.tsystems.coe.techunicorn.client.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AssessmentStatus Class.
 */
@AllArgsConstructor
@Getter
public enum AssessmentStatus {
	NEW("NEW"), TOKEN_SENT("TOKEN SENT"), TOKEN_EXPIRED("TOKEN EXPIRED"), TEST_STARTED("TEST STARTED"),
	TEST_FINISHED("TEST FINISHED"), AUTO_ASSESSMENT_READY("AUTO ASSESSMENT READY"),
	ASSESSMENT_COMPLETED("ASSESSMENT_COMPLETED"), ERROR("ERROR"), CANCELED("CANCELED");

	private String id;
}
