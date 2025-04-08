package com.tsystems.coe.techunicorn.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * Test
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "tests", uniqueConstraints = @UniqueConstraint(name = "UK_provider_id", columnNames = { "provider_id" }))
public class Test extends AbstractAuditEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "provider_id")
	private String providerId;

	@Column(name = "name")
	private String name;

	@Column(name = "duration_in_minutes")
	private Integer durationInMinutes;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "test_skills",
			uniqueConstraints = @UniqueConstraint(name = "UK_skill_id", columnNames = { "skill_id" }),
			joinColumns = @JoinColumn(name = "test_id", foreignKey = @ForeignKey(name = "FK_test_test_skills")),
			inverseJoinColumns = @JoinColumn(name = "skill_id",
					foreignKey = @ForeignKey(name = "FK_skills_test_skills")))
	private List<Skill> skills;

}
