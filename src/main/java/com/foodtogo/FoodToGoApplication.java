package com.foodtogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class FoodToGoApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodToGoApplication.class, args);
	}
}
