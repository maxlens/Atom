package com.quark.atom.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InventoryFileSink {

	String INPUT = "invFileSink";

	@Input(INPUT)
	SubscribableChannel invFileInput();
	
}
