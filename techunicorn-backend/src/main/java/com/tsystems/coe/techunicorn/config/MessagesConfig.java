package com.tsystems.coe.techunicorn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Messages configuration class.
 */
@Configuration
public class MessagesConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasenames("messages");
		source.setUseCodeAsDefaultMessage(true);

		return source;
	}

}
