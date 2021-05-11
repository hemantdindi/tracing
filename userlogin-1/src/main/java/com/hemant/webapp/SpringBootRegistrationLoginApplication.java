package com.hemant.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRegistrationLoginApplication {
	   private static final Logger logger = LoggerFactory.getLogger(SpringBootRegistrationLoginApplication.class);

	   
	public static void main(String[] args) {
		System.out.println("Sample Log " + logger.toString());
		logger.info("App Started");
		SpringApplication.run(SpringBootRegistrationLoginApplication.class, args);
	}

}
