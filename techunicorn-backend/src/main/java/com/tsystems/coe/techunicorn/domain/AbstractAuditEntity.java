package com.tsystems.coe.techunicorn.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Audit superclass, which provides the common attributed for audited instances.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractAuditEntity extends AbstractVersionedEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Logical deletion flag (1 == true == logically deleted instance).
	 */
	@Column(name = "deleted", length = 1, nullable = false)
	private Boolean deleted;

	/**
	 * Creation username.
	 */
	@Column(name = "creation_user", length = 40, nullable = false, updatable = false)
	private String creationUser;

	/**
	 * Creation date.
	 */
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date", nullable = false, updatable = false)
	private Date creationDate;

	/**
	 * Last update username.
	 */
	@Column(name = "update_user", length = 40, nullable = false)
	private String updateUser;

	/**
	 * Last update date.
	 */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false)
	private Date updateDate;

	/**
	 * Logical deletion username.
	 */
	@Column(name = "deletion_user", length = 40)
	private String deletionUser;

	/**
	 * Logical deletion date.
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deletion_date")
	private Date deletionDate;

	/**
	 * Initial creation values method.
	 */
	@PrePersist
	public void onPrePersist() {
		this.setDeleted(false);
		this.setCreationUser("TBD");
		this.setUpdateUser("TBD");
	}

	/**
	 * Update values method.
	 */
	@PreUpdate
	public void onPreUpdate() {
		this.setUpdateUser("TBD");
		if (this.getDeleted()) {
			this.setDeletionUser("TBD");
			this.setDeletionDate(new Date());
		}
	}

}
