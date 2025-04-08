package com.tsystems.coe.techunicorn.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.coe.techunicorn.domain.AbstractAuditEntity;
import com.tsystems.coe.techunicorn.domain.AbstractVersionedEntity;
import com.tsystems.coe.techunicorn.exception.EntityLockedException;

import lombok.extern.log4j.Log4j2;

/**
 * Base repository implementation.
 *
 * @param <T> Persistence entity.
 * @param <I> Persistence key.
 */
@Log4j2
public class BaseRepositoryImpl<T extends AbstractAuditEntity, I> extends SimpleJpaRepository<T, I>
		implements BaseRepository<T, I> {

	private JpaEntityInformation<T, I> entityInformation;

	/**
	 * Base repository constructor, which performs the dependency injection from
	 * SimpleJpaRepository.
	 * 
	 * @param entityInformation JpaEntityInformation instance.
	 * @param entityManager     EntityManager instance.
	 */
	public BaseRepositoryImpl(JpaEntityInformation<T, I> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityInformation = entityInformation;
	}

	@Override
	@Transactional
	public <S extends T> S save(S entity, final long version) throws EntityLockedException {
		log.debug("save({}, {})", entity, version);
		// Registers optimistic lock during update actions.
		if (entity instanceof AbstractVersionedEntity && !this.entityInformation.isNew(entity)) {
			final I id = this.entityInformation.getId(entity);
			if (id != null && version != ((AbstractVersionedEntity) this.getById(id)).getVersion()) {
				throw new EntityLockedException(entity);
			}
		}
		// SimpleJpaRepository persistency method invocation.
		return super.saveAndFlush(entity);
	}

	@Override
	public void softDelete(I id) {
		log.debug("softDelete({})", id);
		// Gather the instance by its id.
		T t = this.getById(id);

		// Update the soft deletion flag of the instance.
		t.setDeleted(true);

		// Persist the instance.
		this.save(t);
	}

}
