package com.tsystems.coe.techunicorn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration class.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Configuration bean for Swagger.
	 * 
	 * @return Configured Docket instance.
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("techunicorn-api").select()
				.apis(RequestHandlerSelectors.basePackage("com.tsystems.coe.techunicorn.controller"))
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());

	}

	/**
	 * Returns an ApiInfo instance with the general information of the API.
	 * 
	 * @return The ApiInfo instance.
	 */
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("TechUnicorn API").description("T-Systems TechUnicorn project API")
				.version("1.0").termsOfServiceUrl("http://tbd.t-systems.com").build();
	}

}
