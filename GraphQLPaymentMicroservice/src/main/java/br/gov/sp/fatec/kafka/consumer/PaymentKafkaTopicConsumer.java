package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.address.CreateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.contact.CreatekafkaContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateKafkaContactDto;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateKafkaCustomerDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.service.address.AddressService;
import br.gov.sp.fatec.service.contact.ContactService;
import br.gov.sp.fatec.service.customer.CustomerService;
import br.gov.sp.fatec.service.order.OrderService;

@Service
public class PaymentKafkaTopicConsumer {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private OrderService orderService;
	
	@KafkaListener(topics = Topic.userCreated)
    public void consumeUserCreated(@Payload CreateCustomerDto dto) throws IOException {
		this.logTopicMessage(Topic.userCreated, dto);
		customerService.createCustomer(dto);
    }
	
	@KafkaListener(topics = Topic.userUpdated)
    public void consumeUserUpdated(@Payload UpdateKafkaCustomerDto dto) throws IOException {
		this.logTopicMessage(Topic.userUpdated, dto);
		customerService.updateCustomer(dto);
    }
	
	@KafkaListener(topics = Topic.userDeleted)
    public void consumeUserDeleted(@Payload String id) throws IOException {
		this.logTopicMessage(Topic.userDeleted, id);
		customerService.deleteCustomerByUserId(id);
    }
	
	@KafkaListener(topics = Topic.addressCreated)
    public void consumeAddressCreated(@Payload CreateKafkaAddressDto dto) throws IOException {
		this.logTopicMessage(Topic.addressCreated, dto);
		addressService.createkafkaAddress(dto);
    }
	
	@KafkaListener(topics = Topic.addressUpdated)
    public void consumeAddressUpdated(@Payload UpdateKafkaAddressDto dto) throws IOException {
		this.logTopicMessage(Topic.addressUpdated, dto);
		addressService.updateKafkaAddress(dto);
    }
	
	@KafkaListener(topics = Topic.addressDeleted)
    public void consumeAddressDeleted(@Payload String id) throws IOException {
		this.logTopicMessage(Topic.addressDeleted, id);
		addressService.deleteByUserAddressId(id);
    }
	
	@KafkaListener(topics = Topic.contactCreated)
    public void consumeContactCreated(@Payload CreatekafkaContactDto dto) throws IOException {
		this.logTopicMessage(Topic.contactCreated, dto);
		contactService.createKafkaContact(dto);
    }
	
	@KafkaListener(topics = Topic.contactUpdated)
    public void consumeContactUpdated(@Payload UpdateKafkaContactDto dto) throws IOException {
		this.logTopicMessage(Topic.contactUpdated, dto);
		contactService.updateKafkaContact(dto);
    }
	
	@KafkaListener(topics = Topic.contactDeleted)
    public void consumeContactDeleted(@Payload String id) throws IOException {
		this.logTopicMessage(Topic.contactDeleted, id);
		contactService.deleteByUserContactId(id);
    }
	
	@KafkaListener(topics = Topic.orderStarted)
    public void consumeOrderStarted(@Payload StartOrderDto dto) throws IOException {
		this.logTopicMessage(Topic.orderStarted, dto);
		orderService.startOrder(dto);
    }
	
	private void logTopicMessage(String event, Object message) {
		System.out.println(String.format("##### -> Topic %s consuming message -> %s", event, message));
	}
}
