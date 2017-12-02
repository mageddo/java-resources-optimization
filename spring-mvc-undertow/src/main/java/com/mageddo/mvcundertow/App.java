package com.mageddo.mvcundertow;

import com.mageddo.webfluxnetty.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(Config.class)
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
