package com.company.ResumeWebAppSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.company","com.company.ResumeWebAppSpring"})
public class ResumeWebAppSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeWebAppSpringApplication.class, args);
	}

}
