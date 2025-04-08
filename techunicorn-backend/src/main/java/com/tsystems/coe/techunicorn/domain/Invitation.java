package com.tsystems.coe.techunicorn.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Invitation
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invitations")
public class Invitation extends AbstractAuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "test_id")
	private String testId;

	@Column(name = "validity_in_days")
	private Integer validityInDays;

	@Column(name = "note")
	private String note;
}
