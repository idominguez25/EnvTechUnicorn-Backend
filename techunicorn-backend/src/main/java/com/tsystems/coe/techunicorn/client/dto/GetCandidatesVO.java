package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetCandidates VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetCandidatesVO {

	private EmbeddedCandidateListVO _embedded;
	private PageVO page;
}
