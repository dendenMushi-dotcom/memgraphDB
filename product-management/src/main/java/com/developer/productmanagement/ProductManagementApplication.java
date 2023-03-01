package com.developer.productmanagement;

import jakarta.annotation.PostConstruct;
import org.neo4j.driver.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class ProductManagementApplication {


	public static void main(String[] args) {
		SpringApplication.run(ProductManagementApplication.class, args);
	}
	@Bean
	public NodeCreator nodeCreator() {
		return new NodeCreator();
	}

	}
