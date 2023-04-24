package org.example.eazyschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.example.eazyschool.repository")
@EntityScan("org.example.eazyschool.Model;")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class
EazySchoolApplication {

	public static void main(String[] args) {
	 	SpringApplication.run(EazySchoolApplication.class, args);
	}

}
