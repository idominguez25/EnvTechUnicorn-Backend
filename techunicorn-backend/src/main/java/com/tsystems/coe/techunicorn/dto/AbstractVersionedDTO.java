package com.tsystems.coe.techunicorn.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AbstractVersioned DTO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AbstractVersionedDTO {

	@ApiModelProperty(name = "version",
			value = "Version of the object. Used in updates to perform concurrency control.")
	private int version;

}
