package com.easyschool.example_51;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class Example51Application {

	public static void main(String[] args) {
		SpringApplication.run(Example51Application.class, args);
	}

}
