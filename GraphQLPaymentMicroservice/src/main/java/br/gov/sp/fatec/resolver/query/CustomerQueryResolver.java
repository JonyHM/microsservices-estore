package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.service.customer.CustomerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javassist.NotFoundException;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private CustomerService service;
	
	public List<Customer> getCustomers() {
		return service.getAll();
	}
	
	public Customer getCustomerById(UUID id) throws NotFoundException {
		return service.getById(id);
	}

	public Customer getCustomerByCPF(String cpf) throws NotFoundException {
		return service.getByCPF(cpf);
	}
	
	public Customer getCustomerByUserId(String userId) throws NotFoundException {
		return service.getByUserId(userId);
	}		
}
