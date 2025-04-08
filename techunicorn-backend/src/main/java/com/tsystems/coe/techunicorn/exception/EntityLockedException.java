package com.tsystems.coe.techunicorn.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Exception used to handle the optimistically locked persistence actions.
 */
@Getter
@Setter
@AllArgsConstructor
public class EntityLockedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Serializable entity;

}
