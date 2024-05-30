package com.dtopiast.mercury;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercuryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MercuryApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Program runner = new Program();
		runner.showMenu();
	}

}
