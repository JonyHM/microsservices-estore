package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.order.KafkaTopicOrderDto;

@Service
public class KafkaTopicProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendOrderPaid(KafkaTopicOrderDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.orderPaid, dto));
        this.kafkaTemplate.send(Topic.orderPaid, dto);
    }
	
	public void sendOrderCanceled(KafkaTopicOrderDto dto) {
		System.out.println(String.format("#### -> Producing %s message -> %s", Topic.orderCanceled, dto));
        this.kafkaTemplate.send(Topic.orderCanceled, dto);
    }
}
