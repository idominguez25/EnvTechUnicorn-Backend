package com.tsystems.coe.techunicorn.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Skill DTO Class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@ApiModel(description = "Skill object.")
public class SkillDTO extends AbstractVersionedDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name = "id", value = "The identifier of the skill.", example = "123")
	private Long id;

	@ApiModelProperty(name = "name", value = "Name of the skill.", example = "Java")
	private String name;

	@ApiModelProperty(name = "percentage", value = "Percentage result for the tasks related to the skill.",
			example = "90")
	@JsonIgnore
	private Integer percentage;

}
