package com.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.gestion.repository.ProductoRepositoryImpl.class")
public class GestionVehicular1Application {

	public static void main(String[] args) {
		SpringApplication.run(GestionVehicular1Application.class, args);
	}
}
