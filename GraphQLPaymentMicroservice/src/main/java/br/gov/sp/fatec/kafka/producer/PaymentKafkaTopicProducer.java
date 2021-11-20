package br.gov.sp.fatec.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.kafka.model.Topic;
import br.gov.sp.fatec.model.dto.order.KafkaOrderDto;

@Service
public class PaymentKafkaTopicProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendOrderPaid(KafkaOrderDto dto) {
		this.logTopicMessage(Topic.orderPaid, dto);
        this.kafkaTemplate.send(Topic.orderPaid, dto);
    }
	
	public void sendOrderCanceled(KafkaOrderDto dto) {
		this.logTopicMessage(Topic.orderCanceled, dto);
        this.kafkaTemplate.send(Topic.orderCanceled, dto);
    }
	
	private void logTopicMessage(String event, Object message) {
		System.out.println(String.format("#### -> Topic %s producing message -> %s", event, message));
	}
}
