package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmbeddedInvitation VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmbeddedInvitationVO {

	private AssessmentVO assessment;
	private CandidateVO candidate;

}
