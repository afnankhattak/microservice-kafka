package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Topic;
import com.example.service.TopicService;

@RestController
@RequestMapping("api/v1/topic")
public class TopicController {
	
	@Autowired
	TopicService topicService;
	
	private KafkaTemplate<String, String> kafkaTemplate;

	
	public TopicController(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	@GetMapping(value="/",produces="application/json")
	public List<Topic> getTopics() {
		
		return topicService.list();
		
	}
	
	@PostMapping(value="/message",consumes = "application/json",produces = "application/json")
	public void saveMessage(@RequestBody Topic topic) {
		
		
		kafkaTemplate.send("afnancodetopic", topic.getMessage());

		
		//return topicService.save(topic);
		
	}
	
	@GetMapping(value="/{id}",produces = "application/json")
	public Topic get(@PathVariable Long id) {
		
		return topicService.get(id);
	}
	
	
	@PutMapping(value = "/{id}",consumes = "application/json",produces = "application/json")
	public Topic update(@PathVariable Long id,@RequestBody Topic topic) {
		return topicService.update(id, topic);
	}
	
	@DeleteMapping(value = "/{id}",produces = "application/json")
	public void delete(@PathVariable Long id) {
		topicService.delete(id);
	}
	

}
