package com.tsystems.coe.techunicorn.service;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.tsystems.coe.techunicorn.common.Transactional;

/**
 * Common interface for CRUD services.
 * 
 * @param <T> Type of the DTO used in the service.
 * @param <I> Type of the identifier used in the service.
 */
public interface CrudService<T, I> {

	/**
	 * Creates of an element.
	 * 
	 * @param dto DTO with the information of the element to be created.
	 * @return Created object.
	 */
	@Transactional
	default T create(T dto) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Gathers an element given its identifier.
	 * 
	 * @param id Element identifier.
	 * @return Element instance.
	 */
	default T getById(final I id) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Returns whether an element exists, identifying it by its id.
	 * 
	 * @param id The id of the element.
	 * @return True if exists, false otherwise.
	 */
	default boolean exists(I id) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Returns a list with all the elements of the given type.
	 * 
	 * @return List of elements.
	 */
	default List<T> getAll() {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Updates an element.
	 * 
	 * @param dto DTO with the information of the element to be updated.
	 * @return Updated object.
	 */
	@Transactional
	default T update(T dto) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Performs a soft-delete of an element.
	 * 
	 * @param id Element identifier.
	 */
	@Transactional
	default void softDelete(I id) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Physically deletes an element.
	 * 
	 * @param id Element identifier.
	 */
	@Transactional
	default void delete(final I id) {
		throw new NotImplementedException("This method has no implementation.");
	}

	/**
	 * Physically deletes several elements.
	 * 
	 * @param idList Elements identifiers.
	 */
	@Transactional
	default void delete(final List<I> idList) {
		throw new NotImplementedException("This method has no implementation.");
	}

}
