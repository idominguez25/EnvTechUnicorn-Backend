package com.tsystems.coe.techunicorn.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;
import com.tsystems.coe.techunicorn.client.dto.enums.CandidateStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Candidate
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates",
		uniqueConstraints = @UniqueConstraint(name = "UK_provider_id", columnNames = { "provider_id" }))
public class Candidate extends AbstractAuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "provider_id")
	private String providerId;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "status")
	private CandidateStatus status;

	@OneToMany(mappedBy = "candidate", orphanRemoval = true)
	private List<Assessment> assessments;

}
