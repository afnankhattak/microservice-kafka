package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication()
@ComponentScan(basePackages = { "com.example.kafka","com.example.controller","com.example.service"} )
public class MicroservicesKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesKafkaApplication.class, args);
		//com.example
	}
	
	
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args->{
			
			kafkaTemplate.send("afnancodetopic", "Hello com.example.Kafka from Springboot CommandLineRunner:) ");
			//for(int i=0;i<10;i++) {
				//kafkaTemplate.send("afnancodetopic", "Hello com.example.Kafka from afnan:) "+i);

			//}
			
			
		};
		
	}

}
