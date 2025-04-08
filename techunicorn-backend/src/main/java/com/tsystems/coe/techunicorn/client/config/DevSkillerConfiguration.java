package com.tsystems.coe.techunicorn.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

/**
 * OpenFeign configuration that handles DevSkiller required headers by using an
 * interceptor.
 */
public class DevSkillerConfiguration {

	/**
	 * DevSkiller API Key.
	 */
	@Value("${devskiller.api.key}")
	private String devSkillerApiKey;

	/**
	 * Headers interceptor generator.
	 * 
	 * @return A RequestInterceptor that adds the required headers.
	 */
	@Bean
	public RequestInterceptor addDevSkillerHeaders() {
		return requestTemplate -> {
			requestTemplate.header("Content-Type", "application/vnd.devskiller.v2.hal+json");
			requestTemplate.header("Devskiller-Api-Key", this.devSkillerApiKey);
			requestTemplate.header("Accept", "application/vnd.devskiller.v2.hal+json");
		};
	}
}
