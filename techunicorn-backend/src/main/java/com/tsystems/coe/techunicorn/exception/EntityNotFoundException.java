package com.tsystems.coe.techunicorn.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Exception used to handle the creation of already existing instances.
 */
@Getter
@Setter
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Serializable entity;

}
