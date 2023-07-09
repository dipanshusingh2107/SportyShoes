package com.sportyshoes.AdminPanel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan (basePackages = {"com.sportyshoes.*"})
@EntityScan("com.sportyshoes.*")
@EnableJpaRepositories("com.sportyshoes.*")
@ConfigurationPropertiesScan("com.sportyshoes.*")
public class SportyShoesApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SportyShoesApplication.class, args);
	
	}

}


