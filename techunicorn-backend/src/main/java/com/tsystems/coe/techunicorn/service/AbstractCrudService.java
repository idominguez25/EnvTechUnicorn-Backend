package com.tsystems.coe.techunicorn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.tsystems.coe.techunicorn.domain.AbstractAuditEntity;
import com.tsystems.coe.techunicorn.mapper.BaseMapper;
import com.tsystems.coe.techunicorn.repository.BaseRepository;

import lombok.extern.log4j.Log4j2;

/**
 * Abstract class for the common implementation of methods of the CrudService
 * interface.
 */
@Log4j2
public class AbstractCrudService<T extends AbstractAuditEntity, I, R extends BaseRepository<T, I>, D>
		implements CrudService<D, I> {

	@Autowired
	protected R repository;

	@Autowired
	protected BaseMapper<T, D> mapper;

	@Override
	public D create(D dto) {
		log.debug("create({})", dto);
		return this.mapper.domainToDto(this.repository.save(this.mapper.dtoToDomain(dto)));
	}

	@Override
	public D getById(I id) {
		log.debug("getById({})", id);
		return this.mapper.domainToDto(this.repository.getById(id));
	}

	@Override
	public boolean exists(I id) {
		log.debug("exists({})", id);
		return this.repository.findById(id).isPresent();
	}

	@Override
	public List<D> getAll() {
		log.debug("getAll()");
		return repository.findAll().stream().map(this.mapper::domainToDto).collect(Collectors.toList());
	}

	@Override
	public D update(D dto) {
		log.debug("update({})", dto);
		return this.mapper.domainToDto(this.repository.save(this.mapper.dtoToDomain(dto)));
	}

	@Override
	public void delete(I id) {
		log.debug("delete({})", id);
		this.repository.deleteById(id);
	}

	@Override
	public void delete(List<I> idList) {
		log.info("delete({})", idList);
		this.repository.deleteAllById(idList);
	}

	@Override
	public void softDelete(I id) {
		log.debug("softDelete({})", id);
		this.repository.softDelete(id);
	}

}
