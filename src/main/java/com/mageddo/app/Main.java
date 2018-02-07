package com.mageddo.app;


import com.mageddo.webfluxnetty.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({App.class, com.mageddo.springjob.Main.class})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}
}
