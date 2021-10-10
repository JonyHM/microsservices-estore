package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.StartOrderDto;

@Service
public class KafkaTopicProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendOrderStarted(StartOrderDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.orderStarted, dto));
        this.kafkaTemplate.send(Topic.orderStarted, dto);
    }
}
