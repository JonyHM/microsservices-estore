package br.gov.sp.fatec.kafka.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.address.CreateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.contact.CreatekafkaContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateKafkaContactDto;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateKafkaCustomerDto;

@Service
public class UserKafkaTopicProducer {
	   	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendUserCreated(CreateCustomerDto dto) {
		this.logTopicMessage(Topic.userCreated, dto);
        this.kafkaTemplate.send(Topic.userCreated, dto);
    }
	
	public void sendUserUpdated(UpdateKafkaCustomerDto dto) {
		this.logTopicMessage(Topic.userUpdated, dto);
        this.kafkaTemplate.send(Topic.userUpdated, dto);
    }
	
	public void sendUserDeleted(UUID userId) {
		this.logTopicMessage(Topic.userDeleted, userId);
        this.kafkaTemplate.send(Topic.userDeleted, userId);
    }
	
	public void sendAddressCreated(CreateKafkaAddressDto dto) {
		this.logTopicMessage(Topic.addressCreated, dto);
        this.kafkaTemplate.send(Topic.addressCreated, dto);
    }
	
	public void sendAddressUpdated(UpdateKafkaAddressDto dto) {
		this.logTopicMessage(Topic.addressUpdated, dto);
        this.kafkaTemplate.send(Topic.addressUpdated, dto);
    }
	
	public void sendAddressDeleted(UUID addressId) {
		this.logTopicMessage(Topic.addressDeleted, addressId);
        this.kafkaTemplate.send(Topic.addressDeleted, addressId);
    }
	
	public void sendContactCreated(CreatekafkaContactDto dto) {
		this.logTopicMessage(Topic.contactCreated, dto);
        this.kafkaTemplate.send(Topic.contactCreated, dto);
    }
	
	public void sendContactUpdated(UpdateKafkaContactDto dto) {
		this.logTopicMessage(Topic.contactUpdated, dto);
        this.kafkaTemplate.send(Topic.contactUpdated, dto);
    }
	
	public void sendContactDeleted(UUID contactId) {
		this.logTopicMessage(Topic.contactDeleted, contactId);
        this.kafkaTemplate.send(Topic.contactDeleted, contactId);
    }
	
	private void logTopicMessage(String topic, Object message) {
		System.out.println(String.format("##### -> Topic '%s' producing message -> %s", topic, message));
	}
}
