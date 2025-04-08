package com.tsystems.coe.techunicorn.repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.transaction.annotation.Transactional;

/**
 * Annotation to identify read-only repositories.
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE })
@Documented
@Transactional(readOnly = true)
public abstract @interface ReadOnlyRepository {

}