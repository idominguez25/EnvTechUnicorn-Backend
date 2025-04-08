package com.tsystems.coe.techunicorn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.tsystems.coe.techunicorn.service.CrudService;

import lombok.extern.log4j.Log4j2;

/**
 * Common abstract class for CRUD controllers with a base implementation of
 * common methods.
 * 
 * @param <T> Type of the DTO used in the controller.
 * @param <I> Type of the identifier used in the controller.
 */
@Log4j2
public abstract class AbstractCrudController<T, I> implements CrudController<T, I> {

	@Autowired
	private CrudService<T, I> service;

	@Override
	public ResponseEntity<T> create(T dto) {
		log.debug("create({})", dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
	}

	@Override
	public ResponseEntity<T> getById(@PathVariable("id") final I id) {
		log.debug("getById({})", id);
		return ResponseEntity.ok(service.getById(id));
	}

	@Override
	public ResponseEntity<List<T>> getAll() {
		log.debug("getAll()");
		return ResponseEntity.ok(service.getAll());
	}

	@Override
	public ResponseEntity<T> update(T dto) {
		log.debug("update({})", dto);
		return ResponseEntity.ok(service.update(dto));
	}

	@Override
	public void delete(@PathVariable("id") final I id) {
		log.debug("delete({})", id);
		service.delete(id);
	}

	@Override
	public void delete(List<I> idList) {
		log.info("delete({})", idList);
		service.delete(idList);
	}

}