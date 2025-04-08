package com.tsystems.coe.techunicorn.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Transactional annotation that forces a rollback for all exceptions.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
public @interface Transactional {

}
