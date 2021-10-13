package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.cart.BaseCartDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.service.product.ProductService;

@Service
public class StoreKafkaTopicConsumer {
	
	@Autowired
	private ProductService productService;
	
	@KafkaListener(topics = Topic.orderStarted)
    public void consumeOrderStarted(@Payload StartOrderDto dto) throws IOException {
		this.logTopicMessage(Topic.orderStarted, dto);
		productService.reserveProduct(dto);
    }
	
	@KafkaListener(topics = Topic.cartPaid)
	public void consumeCartPaid(@Payload BaseCartDto dto) throws IOException {
		this.logTopicMessage(Topic.cartPaid, dto);
		productService.updatePaidProducts(dto);
    }
	
	@KafkaListener(topics = Topic.cartCanceled)
	public void consumeCartCanceled(@Payload BaseCartDto dto) throws IOException {
		this.logTopicMessage(Topic.cartCanceled, dto);
		productService.updateCanceledProducts(dto);
    }
	
	private void logTopicMessage(String event, Object message) {
		System.out.println(String.format("##### -> Topic %s consuming message -> %s", event, message));
	}
}
