package com.ironhack.lab402;

import com.ironhack.lab402.Component.Creator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Autowired
	Creator creator;

	@Override
	public void run(String... args) throws Exception {
		//creator.createAndSave();
	}

}
