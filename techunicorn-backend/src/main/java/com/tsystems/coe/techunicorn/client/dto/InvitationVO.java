package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Invitation VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvitationVO {

	private String id;
	private EmbeddedInvitationVO _embedded;
	private LinkSelfVO links;

}
