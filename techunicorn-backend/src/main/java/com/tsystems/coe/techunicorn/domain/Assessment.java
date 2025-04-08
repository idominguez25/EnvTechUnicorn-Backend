package com.tsystems.coe.techunicorn.domain;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Assessment
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "assessments",
		uniqueConstraints = @UniqueConstraint(name = "UK_provider_id", columnNames = { "provider_id" }))
public class Assessment extends AbstractAuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "provider_id")
	private String providerId;

	@Column(name = "status")
	private AssessmentStatus status;

	@Column(name = "start_date")
	private ZonedDateTime startDate;
	@Column(name = "finish_date")
	private ZonedDateTime finishDate;

	@Column(name = "time_taken")
	private Integer timeTakenInSeconds;
	@Column(name = "time_limit")
	private Integer timeLimitInSeconds;

	// Score
	@Column(name = "scored_points")
	private Integer scoredPoints;
	@Column(name = "max_points")
	private Integer maxPoints;
	@Column(name = "percentage")
	private Integer percentage;

	// Candidate link.
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_candidates_assessments"))
	private Candidate candidate;

}
