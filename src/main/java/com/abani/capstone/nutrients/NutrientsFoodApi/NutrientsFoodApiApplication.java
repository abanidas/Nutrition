package com.abani.capstone.nutrients.NutrientsFoodApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
public class NutrientsFoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutrientsFoodApiApplication.class, args);
	}
}
