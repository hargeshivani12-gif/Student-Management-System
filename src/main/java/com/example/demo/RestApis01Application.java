package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication()
public class RestApis01Application {

	public static void main(String[] args) {
		SpringApplication.run(RestApis01Application.class, args);
		System.out.println("hello");
	}

}
