package br.gov.sp.fatec.service.customer;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.repository.CustomerRepository;

public class CustomerServiceImplement implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public Customer createCustomer(Customer customer) {
		return repository.save(customer);
	}

}
