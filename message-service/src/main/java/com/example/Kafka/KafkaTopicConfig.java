package com.example.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	

	public KafkaTopicConfig() {
		// TODO Auto-generated constructor stub
	}

	
	@Bean
	public NewTopic myNewTopic() {
		return TopicBuilder.name("afnancodetopic")
				.build();
	}
}
