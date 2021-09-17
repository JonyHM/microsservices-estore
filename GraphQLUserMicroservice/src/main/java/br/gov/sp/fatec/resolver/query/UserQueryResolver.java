package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.service.user.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private UserService service;
	
	public List<User> getUsers() {
		return service.getAll();
	}
	
	public User getUserById(UUID id) {
		return service.getById(id);
	}
}
