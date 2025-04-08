package com.tsystems.coe.techunicorn.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmbeddedCandidate VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmbeddedCandidateVO {

	private List<AssessmentVO> assessments;

}
