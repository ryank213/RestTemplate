package com.quintrix.jfs.testrest.TestRest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.quintrix.jfs.testrest.TestRest.service.StudentService;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public StudentService studentService() {
//		return new StudentService();
//	}
}
