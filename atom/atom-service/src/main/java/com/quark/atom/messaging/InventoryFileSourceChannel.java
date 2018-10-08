package com.quark.atom.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface InventoryFileSourceChannel {

	String OUTPUT = "invFileOutput";

	@Output(InventoryFileSourceChannel.OUTPUT)
	MessageChannel invFileOutput();
}
