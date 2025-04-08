package com.tsystems.coe.techunicorn.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmbeddedCandidateList VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmbeddedCandidateListVO {

	private List<CandidateVO> candidates;

}
