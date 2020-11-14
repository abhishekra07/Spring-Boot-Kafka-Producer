package com.codelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/producer")
public class ProducerResource {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private final String TOPIC_NAME = "firstTopic";
	
	@GetMapping("{message}")
	public String produceMessage(@PathVariable("message") final String message) {
		kafkaTemplate.send(TOPIC_NAME, message);
		return "Produced Successfully";
	}
}
