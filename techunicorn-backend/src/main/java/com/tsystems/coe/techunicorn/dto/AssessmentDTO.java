package com.tsystems.coe.techunicorn.dto;

import java.time.ZonedDateTime;

import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Assessment DTO Class.
 */
@ApiModel(description = "Assessment object.")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class AssessmentDTO extends AbstractVersionedDTO {

	@ApiModelProperty(name = "id", value = "The identifier of the assessment.")
	private Long id;

	@ApiModelProperty(name = "status", value = "Status of the assessment.")
	private AssessmentStatus status;

	@ApiModelProperty(name = "startDate", value = "Start date of the test, if started.",
			example = "2021-01-01T00:00:00+02:00")
	private ZonedDateTime startDate;
	@ApiModelProperty(name = "finishDate", value = "Finish date of the test, if finished.",
			example = "2021-01-01T00:00:00+02:00")
	private ZonedDateTime finishDate;

	@ApiModelProperty(name = "timeTakenInSeconds", value = "Elapsed time took to do the test.")
	private int timeTakenInSeconds;
	@ApiModelProperty(name = "timeLimitInSeconds", value = "Maximum time allowed to take the test.")
	private int timeLimitInSeconds;

	// Score
	@ApiModelProperty(name = "scoredPoints", value = "Scored points in the test.")
	private Integer scoredPoints;
	@ApiModelProperty(name = "maxPoints", value = "Maximum points achievable in the test.")
	private Integer maxPoints;
	@ApiModelProperty(name = "percentage", value = "Score in base 100.")
	private Integer percentage;

}
