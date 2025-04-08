package com.tsystems.coe.techunicorn.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Test DTO Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(description = "Test object.")
public class TestDTO extends AbstractVersionedDTO {

	@ApiModelProperty(name = "id", value = "The identifier of the test.", example = "123")
	private Long id;

	@ApiModelProperty(name = "providerId", value = "The profider identifier of the test.", example = "123-abc")
	@JsonIgnore // Hide from the REST interface.
	private String providerId;

	@ApiModelProperty(name = "name", value = "Test name", example = "Senior Java Developer")
	private String name;

	@ApiModelProperty(name = "skills", value = "List of skills verified in the test.")
	private List<SkillDTO> skills;

	@ApiModelProperty(name = "durationInMinutes", value = "Test duration in minutes")
	private Integer durationInMinutes;
}
