package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CreateInvitation VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateInvitationVO {

	private String email;
	private String testId;
	private Integer validityInDays;
	private String note;

}
