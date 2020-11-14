package com.codelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.model.Employee;

@RestController
@RequestMapping("/api/kafka/producer")
public class ProducerResource {

	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplate;
	
	private final String TOPIC_NAME = "firstTopic";
	
	@PostMapping
	public String produceMessage(@RequestBody Employee employee) {
		kafkaTemplate.send(TOPIC_NAME, employee);
		return "Message Produced Successfully";
	}
}
