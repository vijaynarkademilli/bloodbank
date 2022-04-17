package com.bloodbank.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/saveBloodDetails").allowedMethods("*").allowedOrigins("*");
				registry.addMapping("/getBloodDetails/{bloodGroup}").allowedMethods("*").allowedOrigins("*");
				registry.addMapping("/registerUser").allowedMethods("*").allowedOrigins("*");
				registry.addMapping("/getUserProfile/{userId}").allowedMethods("*").allowedOrigins("*");
			}
		};
	}


}
