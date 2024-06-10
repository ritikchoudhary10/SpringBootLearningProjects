package com.ritik.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.Message;

@Component
public class Sender implements CommandLineRunner{

	@Autowired
	private JmsTemplate template;
	
	@Override
	public void run(String... args) throws Exception {
		template.send("Name3",message("My 1st Message....!"));
		System.out.println("Message Sent..!");
		System.exit(0);
	}
	
	private MessageCreator message(String msg) {
		return (ses)->ses.createTextMessage(msg);
	}
	
	
}
