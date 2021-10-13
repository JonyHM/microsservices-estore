package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.cart.BaseCartDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;

@Service
public class OrderKafkaTopicProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendOrderStarted(StartOrderDto dto) {
		this.logTopicMessage(Topic.orderStarted, dto);
        this.kafkaTemplate.send(Topic.orderStarted, dto);
    }
	
	public void sendCartPaid(BaseCartDto dto) {
		this.logTopicMessage(Topic.cartPaid, dto);
        this.kafkaTemplate.send(Topic.cartPaid, dto);
    }
	
	public void sendCartCanceled(BaseCartDto dto) {
		this.logTopicMessage(Topic.cartCanceled, dto);
        this.kafkaTemplate.send(Topic.cartCanceled, dto);
    }
	
	private void logTopicMessage(String event, Object message) {
		System.out.println(String.format("#### -> Topic %s producing message -> %s", event, message));
	}
}
