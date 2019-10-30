package edu.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
//<mvc:annotation-driven>
@ComponentScan("edu.ssafy.controller")
//<context:componentscan base-package="">
public class MVCConfig extends WebMvcConfigurerAdapter{
	
}
