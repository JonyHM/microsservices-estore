package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.dto.Topic;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;

@Service
public class KafkaTopicProducer {
	   	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendUserCreated(CreateCustomerDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.userCreated, dto));
        this.kafkaTemplate.send(Topic.userCreated, dto);
    }
}
