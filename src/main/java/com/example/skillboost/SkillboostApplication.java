package com.example.skillboost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class SkillboostApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillboostApplication.class, args);
	}

}
