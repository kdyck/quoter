package com.kdyck.stonks.quoter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QuoterApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoterApplication.class, args);
	}
}
