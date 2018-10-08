package com.quark.atom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.quark.atom.messaging.InventoryFileSink;
import com.quark.atom.messaging.InventoryFileSourceChannel;

@SpringBootApplication
@EnableBinding({InventoryFileSourceChannel.class, InventoryFileSink.class})
//(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class AtomApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtomApplication.class, args);
	}
}
