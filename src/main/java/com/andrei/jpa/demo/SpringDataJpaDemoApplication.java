package com.andrei.jpa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main class for the spring boot app.
 *
 * @author Andrei Moldovan.
 * @since 30.07.2017
 */
@SpringBootApplication
@EnableJpaAuditing
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}
}
