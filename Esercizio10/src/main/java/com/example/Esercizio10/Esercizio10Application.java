package com.example.Esercizio10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.Esercizio10")
@ComponentScan(basePackages = { "com.example.Esercizio10" })
@EntityScan("com.example.Esercizio10")
public class Esercizio10Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio10Application.class, args);
	}

}
