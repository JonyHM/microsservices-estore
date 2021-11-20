package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.user.CrateUserDto;
import br.gov.sp.fatec.model.dto.user.UpdateUserDto;
import br.gov.sp.fatec.service.user.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private UserService service;
	
	public User createUser(CrateUserDto user) {
		return service.createUser(user);
	}
	
	public User updateUser(UpdateUserDto user) {
		return service.updateUser(user);
	}
	
	public String deleteUser(UUID userId) {
		return service.deleteUser(userId);
	}	
	
}
