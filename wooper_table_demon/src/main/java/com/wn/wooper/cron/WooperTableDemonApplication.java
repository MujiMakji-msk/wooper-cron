package com.wn.wooper.cron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WooperTableDemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(WooperTableDemonApplication.class, args);
	}

}
