package br.gov.sp.fatec.kafka.consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.StartOrderDto;
import br.gov.sp.fatec.model.dto.order.KafkaTopicOrderDto;
import br.gov.sp.fatec.service.product.ProductService;

@Service
public class KafkaTopicConsumer {
	
	@Autowired
	private ProductService productService;
	
	@KafkaListener(topics = Topic.orderStarted)
    public void consumeOrderStarted(@Payload StartOrderDto dto) throws IOException {
		System.out.println("pre saves customer object with its ID and description for further payment");
		System.out.println(dto);
		productService.preCreateProduct(dto);
    }
	
	@KafkaListener(topics = Topic.orderPaid)
	public void consumeOrderPaid(@Payload KafkaTopicOrderDto dto) throws IOException {
		System.out.println("saves order object with its ID and description for further payment");
		System.out.println(dto);
    }
	
	@KafkaListener(topics = Topic.orderCanceled)
	public void consumeOrderCanceled(@Payload KafkaTopicOrderDto dto) throws IOException {
		System.out.println("saves order object with its ID and description for further payment");
		System.out.println(dto);
    }
}
