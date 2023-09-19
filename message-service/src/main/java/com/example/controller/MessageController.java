package com.example.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kafka.MessageRequest;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
	
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	
	@GetMapping(value = "/")
    public String getMessage() {
        return "Hello Message";
    }
	
	
	public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}


	@PostMapping
	public void publish(@RequestBody MessageRequest request) {
		
		
		kafkaTemplate.send("afnancodetopic", request.massage());
	}

	
}
