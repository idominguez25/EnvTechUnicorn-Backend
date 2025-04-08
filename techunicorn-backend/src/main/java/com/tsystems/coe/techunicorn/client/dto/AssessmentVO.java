package com.tsystems.coe.techunicorn.client.dto;

import java.time.ZonedDateTime;
import java.util.List;

import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Assessment VO Class.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AssessmentVO {

	private String id;

	private AssessmentStatus status;

	private ZonedDateTime creationDate;
	private ZonedDateTime startDate;
	private ZonedDateTime finishDate;

	private int timeTakenInSeconds;
	private int timeLimitInSeconds;

	private ScoreVO score;

	private List<SkillVO> skills;
	private List<SectionVO> sections;
	private EmbeddedAssessmentVO _embedded;
	private LinksAssessmentVO _links;

}
