package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;

@Service
public class KafkaTopicProducer {
	   	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendUserCreated(CreateCustomerDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.userCreated, dto));
        this.kafkaTemplate.send(Topic.userCreated, dto);
    }
	
	public void sendAddressCreated(CreateAddressDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.addressCreated, dto));
        this.kafkaTemplate.send(Topic.addressCreated, dto);
    }
	
	public void sendContactCreated(CreateContactDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.contactCreated, dto));
        this.kafkaTemplate.send(Topic.contactCreated, dto);
    }
}
