package com.tsystems.coe.techunicorn.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Exception used to handle querying non-existant instances.
 */
@Getter
@Setter
@AllArgsConstructor
public class EntityExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Serializable entity;

}
