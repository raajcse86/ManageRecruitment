package com.app.EmployeeDetailsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.app.config.RibbonConfiguration;

@SpringBootApplication 
@ComponentScan(value={"com.app.controllers","com.app.repositories","com.app.services","com.app.jwt","com.app.jwt.resource"})
@EnableMongoRepositories(value= {"com.app.repositories"})
@RibbonClient(name = "register-user-service", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
public class EmployeeDetailsServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsServiceApplication.class, args);
	}

}
