package com.smartcat.Smartcat_demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "smartcat";

	@Autowired
	private static KafkaTemplate<String, String> kafkaTemplate;

	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		Producer.kafkaTemplate = kafkaTemplate;
	}

	public static void sendMessage(String message) {
		logger.info(String.format("Producing message -> %s", message));
		kafkaTemplate.send(TOPIC, message);
	}

}
