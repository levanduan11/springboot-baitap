package com.bai1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class Bai1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bai1Application.class, args);
		System.out.printf(UUID.randomUUID().toString().substring(5));
	}

}
