package com.example.dbclmtest.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.dbclmtest.infrastructure")
@EntityScan(basePackages = "com.example.dbclmtest.domain")
public class DbclmtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbclmtestApplication.class, args);
	}

}
