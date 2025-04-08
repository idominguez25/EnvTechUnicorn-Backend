package com.tsystems.coe.techunicorn.client.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * LinksAssessment VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class LinksAssessmentVO extends LinkSelfVO {

	private Map<String, String> candidateAccess;
	private Map<String, String> onlineReport;
	private Map<String, String> pdfReport;
	private Map<String, String> candidateUrl;

}
