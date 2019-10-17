package com.ssafy.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.model.service.ProductServiceImpl;

@Configuration
@ComponentScan(basePackages= {"com.ssafy.model.repository", "com.ssafy.model.service"})
public class ProductConfig {

	@Bean
	public ProductServiceImpl getService() {
		return new ProductServiceImpl();
	}
	
}
