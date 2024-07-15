package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("kafka")
public class JsonObjectSerializer {
	@Autowired
	KafkaTemplate<String, Employee> kafkaTemplate;
	
	@GetMapping("/send/{name}/{topics}")
	public String sendMessage(@PathVariable String name, @PathVariable String Topics) {
		
		Employee employee = new Employee(name);
		
		kafkaTemplate.send(employee.getName(),employee);
		return "Message send ....";
	}
	

}
