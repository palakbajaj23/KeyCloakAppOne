package com.demo.keycloak;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import rest.demo.keycloak.service.KeyCloakLoginService;
import rest.demo.keycloak.service.KeyCloakLoginServiceImpl;

@SpringBootApplication
@ComponentScan(basePackages = {"rest.demo.keycloak","com.demo.keycloak"})
public class KeyCloakAppOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyCloakAppOneApplication.class, args);
	}

	@Bean
	public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

}