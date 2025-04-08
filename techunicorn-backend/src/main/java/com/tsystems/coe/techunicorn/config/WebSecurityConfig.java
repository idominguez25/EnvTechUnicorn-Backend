package com.tsystems.coe.techunicorn.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers("/*").permitAll().and().csrf().disable();
		http.cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cors = new CorsConfiguration();
				cors.addAllowedOrigin("*");
				cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
				return cors;
			}
		});
	}

}

//@Configuration
//@EnableWebMvc
//public class WebSecurityConfig implements WebMvcConfigurer {
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
//	}
//}