package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.service.address.AddressService;
import br.gov.sp.fatec.service.contact.ContactService;
import br.gov.sp.fatec.service.customer.CustomerService;

@Service
public class KafkaTopicConsumer {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ContactService contactService;
	
	@KafkaListener(topics = Topic.userCreated)
    public void consumeUserCreated(@Payload CreateCustomerDto dto) throws IOException {
		System.out.println("pre saves customer object with its ID and description for further payment");
		System.out.println(dto);
		customerService.createCustomer(dto);
    }
	
	@KafkaListener(topics = Topic.addressCreated)
    public void consumeAddressCreated(@Payload CreateAddressDto dto) throws IOException {
		System.out.println("Search for Customer and create address with dto");
		System.out.println(dto);
		addressService.createAddress(dto);
    }
	
	@KafkaListener(topics = Topic.contactCreated)
    public void consumeContactCreated(@Payload CreateContactDto dto) throws IOException {
		System.out.println("Search for Customer and create contact with dto");
		System.out.println(dto);
		contactService.createContact(dto);
    }
	
	@KafkaListener(topics = Topic.orderStarted)
	public void consumeOrderStarted(@Payload StartOrderDto dto) throws IOException {
		System.out.println("saves order object with its ID and description for further payment");
		System.out.println(dto);
    }
}
