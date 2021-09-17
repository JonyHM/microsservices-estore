package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.kafka.producer.KafkaTopicProducer;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.CrateUserDto;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;
import br.gov.sp.fatec.service.user.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private UserService service;
	
	@Autowired
	private KafkaTopicProducer producer;
	
	public User createUser(CrateUserDto user) {
		User newUser = service.createUser(user);
		CreateCustomerDto dto = new CreateCustomerDto(newUser.getName(), newUser.getId(), newUser.getCpf());
		producer.sendUserCreated(dto);
		return newUser;
	}
}
