package com.tsystems.coe.techunicorn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Test Request DTO Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(description = "Test Request object.")
public class InviteCandidateDTO extends AbstractVersionedDTO {

	@ApiModelProperty(name = "candidate", value = "Candidate object.")
	private CandidateDTO candidate;

	@ApiModelProperty(name = "test", value = "Test object.")
	private TestDTO test;

}
