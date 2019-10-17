package com.ssafy.student.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.student.biz.StudentServiceImpl;

@Configuration
@ComponentScan(basePackages= {"com.ssafy.student.biz","com.ssafy.student.dao"})
public class StudentConfig {

	@Bean
	public StudentServiceImpl getService(){
		return new StudentServiceImpl();
	}
	
}
