package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringEmpBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringEmpBackendApplication.class, args);
		
		System.out.println(context.getBean(SpringEmpBackendApplication.class));
		
		
		
	}

}
