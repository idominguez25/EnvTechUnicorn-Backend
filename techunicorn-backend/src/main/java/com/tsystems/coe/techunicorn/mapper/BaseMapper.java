package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;

/**
 * 
 * Base mapper interface.
 *
 * @param <E> Entity
 * @param <D> Domain
 */
public interface BaseMapper<E, D> {

	E dtoToDomain(D dto);

	@InheritInverseConfiguration(name = "dtoToDomain")
	D domainToDto(E entidad);
}
