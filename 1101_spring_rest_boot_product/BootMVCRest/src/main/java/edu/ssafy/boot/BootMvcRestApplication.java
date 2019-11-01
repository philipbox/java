package edu.ssafy.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BootMvcRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcRestApplication.class, args);
		
//		new SpringApplicationBuilder(BootMvcRestApplication.class)
//		.properties(PROPERTIES)
//		.build();
		
	}
	
//	private static final String PROPERTIES=
//			"spring.config.location="
//			+"classpath:/application1.properties"
//			+", classpath:/application.yml";
	
	
	
}
