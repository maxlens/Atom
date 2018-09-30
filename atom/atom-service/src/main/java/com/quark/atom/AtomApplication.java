package com.quark.atom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class AtomApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtomApplication.class, args);
	}
}
