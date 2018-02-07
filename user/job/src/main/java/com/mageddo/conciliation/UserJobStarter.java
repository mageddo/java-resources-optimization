package com.mageddo.conciliation;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRabbit
@Import(Config.class)
public class UserJobStarter {
	public static void main(String[] args) {
		SpringApplication.run(UserJobStarter.class, args);
	}

}
