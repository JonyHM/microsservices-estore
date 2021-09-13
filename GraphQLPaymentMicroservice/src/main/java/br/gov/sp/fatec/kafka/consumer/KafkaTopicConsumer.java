package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.StartOrderDto;
import br.gov.sp.fatec.service.customer.CustomerService;

@Service
public class KafkaTopicConsumer {
	
	@Autowired
	private CustomerService customerService;
	
	@KafkaListener(topics = Topic.userCreated)
    public void consumeUserCreated(@Payload CreateCustomerDto dto) throws IOException {
		System.out.println("pre saves customer object with its ID and description for further payment");
		System.out.println(dto);
		customerService.createCustomer(dto);
    }
	
	@KafkaListener(topics = Topic.orderStarted)
	public void consumeOrderStarted(@Payload StartOrderDto dto) throws IOException {
		System.out.println("saves order object with its ID and description for further payment");
		System.out.println(dto);
    }
}
