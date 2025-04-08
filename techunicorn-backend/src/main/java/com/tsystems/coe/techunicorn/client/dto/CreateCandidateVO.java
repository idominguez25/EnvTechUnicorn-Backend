package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateCandidate VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCandidateVO {

	private String email;
	private String firstName;
	private String lastName;
	private String[] tags;
	private String externalId;
	private boolean disableCommunication;

}
