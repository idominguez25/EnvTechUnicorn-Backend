package com.tsystems.coe.techunicorn.client.dto;

import java.time.ZonedDateTime;

import com.tsystems.coe.techunicorn.client.dto.enums.CandidateStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Candidate VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateVO {

	private String id;

	private String externalId;

	private String email;
	private String firstName;
	private String lastName;

	private CandidateStatus status;

	private String[] tags;
	private boolean disableCommunication;
	private String assignedUser;
	private String assignedTeam;
	private ZonedDateTime creationDate;

	private EmbeddedCandidateVO _embedded;

	private LinksCandidateVO _links;

}
