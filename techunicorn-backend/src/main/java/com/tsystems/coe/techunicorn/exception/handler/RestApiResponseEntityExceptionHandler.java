package com.tsystems.coe.techunicorn.exception.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tsystems.coe.techunicorn.exception.EntityLockedException;

@ControllerAdvice
public class RestApiResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	/**
	 * Optimistic lock exceptions handler.
	 * 
	 * @param ex      The exception.
	 * @param request Original request.
	 * @return 423 - Locked response.
	 */
	@ExceptionHandler(EntityLockedException.class)
	public ResponseEntity<Object> handleValidationException(final EntityLockedException ex, final WebRequest request) {
		return ResponseEntity.status(HttpStatus.LOCKED)
				.body(ApplicationErrorCode.OPTIMISTIC_LOCK_ERROR.getReasonPhrase());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleValidationException(final Exception ex, final WebRequest request) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ApplicationErrorCode.TECHNICAL_ERROR.getReasonPhrase());
	}

}