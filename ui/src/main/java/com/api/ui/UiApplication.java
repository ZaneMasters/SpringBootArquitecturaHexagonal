package com.api.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.api")
public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
	}

}
