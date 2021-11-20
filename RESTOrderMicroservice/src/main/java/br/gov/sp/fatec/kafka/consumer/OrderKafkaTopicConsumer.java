package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.order.KafkaOrderDto;
import br.gov.sp.fatec.service.cart.CartService;

@Service
public class OrderKafkaTopicConsumer {
	
	@Autowired
	private CartService cartService;

	@KafkaListener(topics = Topic.orderPaid)
    public void consumeOrderPaid(@Payload KafkaOrderDto dto) throws IOException {
		this.logTopicMessage(Topic.orderPaid, dto);
		cartService.updatePaidCart(dto);
    }
	
	@KafkaListener(topics = Topic.orderCanceled)
    public void consumeOrderCanceled(@Payload KafkaOrderDto dto) throws IOException {
		this.logTopicMessage(Topic.orderCanceled, dto);
		cartService.updateCanceledCart(dto);
    }
	
	private void logTopicMessage(String event, Object message) {
		System.out.println(String.format("#### -> Topic %s consuming message -> %s", event, message));
	}
}
