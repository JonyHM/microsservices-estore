package br.gov.sp.fatec.service.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;
import br.gov.sp.fatec.repository.CustomerRepository;
import javassist.NotFoundException;

@Service
public class CustomerServiceImplement implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> getAll() {
		return repository.findAll();
	}
	
	@Override
	public Customer createCustomer(CreateCustomerDto dto) {
		Customer customer = new Customer(dto);
		return repository.save(customer);
	}

	@Override
	public Customer getById(UUID id) throws NotFoundException {
		Optional<Customer> optionalCustomer = repository.findById(id);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Customer with id %s does not exists!", id));
	}

	@Override
	public Customer getByCPF(String cpf) throws NotFoundException {
		Optional<Customer> optionalCustomer = repository.findByCpf(cpf);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Customer with CPF '%s' does not exists!", cpf));
	}

	@Override
	public Customer getByUserId(UUID userId) throws NotFoundException {
		Optional<Customer> optionalCustomer = repository.findByUserId(userId);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Customer with user id '%s' does not exists!", userId));
	}

}
