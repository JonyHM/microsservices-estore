package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;
import br.gov.sp.fatec.service.customer.CustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private CustomerService service;

	public Customer createCustomer(CreateCustomerDto dto) throws NotFoundException {
		return service.createCustomer(dto);
	}
}
