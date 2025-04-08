package com.tsystems.coe.techunicorn.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EntityManager properties class.
 */
@NoArgsConstructor
@Getter
@Setter
public class EntityManagerProperties {
	private String[] packagesToScan;
}
