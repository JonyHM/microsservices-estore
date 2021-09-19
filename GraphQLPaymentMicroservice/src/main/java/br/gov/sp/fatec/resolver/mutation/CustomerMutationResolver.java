package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateCustomerDto;
import br.gov.sp.fatec.service.customer.CustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private CustomerService service;

	public Customer createCustomer(CreateCustomerDto customer) throws NotFoundException {
		return service.createCustomer(customer);
	}
	
	public Customer updateCustomer(UpdateCustomerDto customer) {
		return service.updateCustomer(customer);
	}
	
	public String deleteCustomer(UUID customerId) {
		return service.deleteCustomer(customerId);
	}
}
