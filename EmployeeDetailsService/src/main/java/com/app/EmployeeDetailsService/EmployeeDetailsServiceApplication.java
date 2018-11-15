package com.app.EmployeeDetailsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.services.EmployeeDetailsServiceImpl;

@SpringBootApplication
@ComponentScan(value={"com.app.controllers","com.app.repositories","com.app.services"})
@EnableMongoRepositories(value= {"com.app.repositories"})
public class EmployeeDetailsServiceApplication extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsServiceApplication.class, args);
	}
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EmployeeDetailsServiceImpl.class);
	}
}
