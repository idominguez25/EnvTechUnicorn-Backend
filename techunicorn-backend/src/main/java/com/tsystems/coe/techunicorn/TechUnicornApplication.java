package com.tsystems.coe.techunicorn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableFeignClients
@EnableScheduling
public class TechUnicornApplication implements CommandLineRunner {

	/**
	 * SpringBoot entrypoint.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(TechUnicornApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
