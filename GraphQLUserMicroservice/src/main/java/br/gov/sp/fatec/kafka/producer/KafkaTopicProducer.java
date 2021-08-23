package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicProducer {
	   	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		System.out.println(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send("topico.comando.teste", message);
    }
}
