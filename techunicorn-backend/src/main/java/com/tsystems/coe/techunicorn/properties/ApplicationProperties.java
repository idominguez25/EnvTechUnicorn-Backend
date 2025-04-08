package com.tsystems.coe.techunicorn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Application properties class.
 */
@ConfigurationProperties(prefix = "application")
@Component
@NoArgsConstructor
@Getter
@Setter
public class ApplicationProperties {

	private String version;
}
