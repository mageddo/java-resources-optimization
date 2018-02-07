package com.mageddo.app;


import com.mageddo.user.UserJobStarter;
import com.mageddo.user.api.UserApiStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({UserApiStarter.class, UserJobStarter.class})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class);
	}
}
