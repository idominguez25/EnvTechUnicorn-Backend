package com.tsystems.coe.techunicorn.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tsystems.coe.techunicorn.client.dto.enums.CandidateStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Candidate DTO Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(description = "Candidate object.")
public class CandidateDTO extends AbstractVersionedDTO {

	@ApiModelProperty(name = "id", value = "The identifier of the candidate.", example = "123")
	private String id;

	@ApiModelProperty(name = "providerId", value = "The provider identifier of the candidate.", example = "123-abc")
	@JsonIgnore // Hide from the REST interface.
	private String providerId;

	@ApiModelProperty(name = "email", value = "The e-mail of the candidate. Mandatory.",
			example = "cristian.requena@t-systems.com")
	private String email;

	@ApiModelProperty(name = "firstName", value = "The first name of the candidate.", example = "Cristian")
	private String firstName;

	@ApiModelProperty(name = "lastName", value = "The last name of the candidate.", example = "Requena Barreda")
	private String lastName;

	@ApiModelProperty(name = "status", value = "Status of the candidate.")
	private CandidateStatus status;

	@ApiModelProperty(name = "assessments", value = "List of assessments of the candidate.")
	private List<AssessmentDTO> assessments;
}
