package com.uta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.uta.repo","com.uta.service","com.uta"})
public class UBSApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(UBSApplication.class, args);
		

	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
