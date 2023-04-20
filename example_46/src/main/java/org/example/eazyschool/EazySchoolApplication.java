package org.example.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = {"org.example.eazyschool.proxy"})
public class
EazySchoolApplication {

	public static void main(String[] args) {
	 	SpringApplication.run(EazySchoolApplication.class, args);
	}

}
