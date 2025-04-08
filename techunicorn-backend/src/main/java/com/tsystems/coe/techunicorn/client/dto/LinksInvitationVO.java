package com.tsystems.coe.techunicorn.client.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LinksInvitation VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinksInvitationVO {

	private Map<String, String> candidateAccess;
	private Map<String, String> onlineReport;
	private Map<String, String> pdfReport;
	private Map<String, String> candidateUrl;

}
