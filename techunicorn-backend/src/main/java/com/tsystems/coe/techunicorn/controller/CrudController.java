package com.tsystems.coe.techunicorn.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Common interface for CRUD controllers.
 * 
 * @param <T> Type of the DTO used in the controller.
 * @param <I> Type of the identifier used in the controller.
 */
@CrossOrigin(origins = "http://localhost:4200")
public interface CrudController<T, I> {

	/**
	 * Creates of an element.
	 * 
	 * @param dto DTO with the information of the element to be created.
	 * @return {@link ResponseEntity} containing the created element.
	 */
	@PostMapping
	@ApiOperation(value = "Creates an object.", code = 201,
			notes = "Performs the creation and persistency actions for a given object.")
	ResponseEntity<T> create(@RequestBody T dto);

	/**
	 * Gathers an element given its identifier.
	 * 
	 * @param id Element identifier.
	 * @return {@link ResponseEntity} containing the element instance.
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "Returns an object.", code = 200, notes = "Gathers an returns an object from its id.")
	ResponseEntity<T> getById(@ApiParam("The identifier of the object") @PathVariable("id") final I id);

	/**
	 * Returns a list with all the elements of the given type.
	 * 
	 * @return {@link ResponseEntity} containing the list of elements.
	 */
	@GetMapping
	@ApiOperation(value = "Returns all the objects.", code = 200,
			notes = "Returns a collection of all the objects of the given type.")
	ResponseEntity<List<T>> getAll();

	/**
	 * Updates an element.
	 * 
	 * @param dto DTO with the information of the element to be updated.
	 * @return {@link ResponseEntity} containing the updated object.
	 */
	@PutMapping
	@ApiOperation(value = "Updates an object.", code = 200,
			notes = "Updates and returns the updated and persisted object.")
	ResponseEntity<T> update(@RequestBody T dto);

	/**
	 * Physically deletes an element.
	 * 
	 * @param id Element identifier.
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Removes an object.", code = 200, notes = "Deletes an object from its id.")
	void delete(@ApiParam("The identifier of the object") @PathVariable("id") final I id);

	/**
	 * Physically deletes a list of elements.
	 * 
	 * @param idList List of element identifiers.
	 */
	@DeleteMapping
	@ApiOperation(value = "Removes a list of objects.", code = 200,
			notes = "Deletes a list of objects given their ids.")
	void delete(@ApiParam("The list of identifiers of the objects.") @RequestBody final List<I> idList);

}