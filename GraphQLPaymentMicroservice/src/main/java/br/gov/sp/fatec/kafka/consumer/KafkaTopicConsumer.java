package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaTopicConsumer {
	
	@KafkaListener(topics = "topico.comando.teste", groupId = "group_id")
    public void consume(String message) throws IOException {
		System.out.println(String.format("#### -> Consumed message -> %s", message));
    }
}
