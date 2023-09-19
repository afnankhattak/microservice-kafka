package com.example.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.model.Topic;
import com.example.service.TopicService;

@Component
public class KafkaListners {

	@Autowired
	TopicService topicService;
	
	@KafkaListener(	topics="afnancodetopic", groupId="groupId")
	void listner(String data) {
		
		
		topicService.save(new Topic(data));
		System.out.println("Listner recieved data"+data+":) ");
	}

}
