package com.tsystems.coe.techunicorn.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * Transactional superclass with audit features that allows performing an
 * optimistic lock mechanism.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractVersionedEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final int BASE_VERSION = 0;

	/**
	 * Versioning field
	 */
	@Column(name = "version", nullable = false)
	private int version;

	/**
	 * Version number initializer for new instances.
	 */
	@PrePersist
	public void versionPrePersist() {
		this.setVersion(BASE_VERSION);
	}

	/**
	 * Automatic version increasing method for updated instances.
	 */
	@PreUpdate
	public void versionPreUpdate() {
		this.setVersion(++this.version);
	}

}
