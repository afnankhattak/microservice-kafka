package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Topic;
import com.example.repositories.TopicRepository;

@Service
public class TopicService {

	
	@Autowired
	TopicRepository topicRepository;
	
	
	
	public List<Topic> list() {
		
		return topicRepository.findAll();
		
	}
	
	
	
	public Topic save(Topic topic) {
		return topicRepository.save(topic);
		
	}
	
	
	public Topic get(Long id) {
		
		Optional<Topic> topicOptional=topicRepository.findById(id);
		
		if(topicOptional.isEmpty()) {
			throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Topic not found");
			
		}
		
		return topicOptional.get();
	}
	
	
	public Topic update(Long id,Topic topic) {
		

		Optional<Topic> topicOptional=topicRepository.findById(id);
		
		if(topicOptional.isEmpty()) {
			throw new ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "Topic not found");
			
		}
		
		Topic existingTopic=topicOptional.get();
		
		existingTopic.setMessage(topic.getMessage());
		
		
		return topicRepository.save(existingTopic);
		
		
	}
	
	
	public void delete(Long id) {
		
		topicRepository.deleteById(id);
		
	}
	
	
	
	
	
}
