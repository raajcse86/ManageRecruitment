package com.app.RegisterUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.app.config.RibbonConfiguration;

@SpringBootApplication
@ComponentScan(value={"com.app.controllers","com.app.repositories","com.app.services","com.app.config"})
@EnableMongoRepositories(value= {"com.app.repositories"})
@RibbonClient(name = "employee-details-service", configuration = RibbonConfiguration.class)
@EnableDiscoveryClient
public class Main extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Main.class);
	}
}

