package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.MessageTest;

@Service
public class KafkaTopicProducer {
	   	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(MessageTest message) {
		System.out.println(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send("USER_CREATED", message);
    }
}
