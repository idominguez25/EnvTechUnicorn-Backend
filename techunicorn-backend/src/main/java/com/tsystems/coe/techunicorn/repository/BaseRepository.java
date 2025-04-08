package com.tsystems.coe.techunicorn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.tsystems.coe.techunicorn.domain.AbstractAuditEntity;
import com.tsystems.coe.techunicorn.exception.EntityLockedException;

/**
 * Base repository with common methods for Audited Entities.
 *
 * @param <T> Persistence entity.
 * @param <I> Persistence key.
 */
@NoRepositoryBean
public interface BaseRepository<T extends AbstractAuditEntity, I>
		extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {

	/**
	 * Persistence method that performs an optimistic locking of the registers
	 * during the update process.
	 * 
	 * @param <S>     Entity class.
	 * @param entity  Persistence entity.
	 * @param version Base version gathered in former operations.
	 * @return Persisted entity.
	 * @throws EntityLockedException Exception that occurs when updating an outdated
	 *                               instance.
	 */
	<S extends T> S save(S entity, long version) throws EntityLockedException;

	/**
	 * Performs the soft deletion of instanced given their id and version.
	 * 
	 * @param id The id of the instance.
	 */
	void softDelete(I id);

}
