package br.gov.sp.fatec.service.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateKafkaCustomerDto;
import br.gov.sp.fatec.repository.CustomerRepository;

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
	public Customer getById(UUID id) {
		Optional<Customer> optionalCustomer = repository.findById(id);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Could not find Customer with id '%s'!", id));
	}

	@Override
	public Customer getByCPF(String cpf) {
		Optional<Customer> optionalCustomer = repository.findByCpf(cpf);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Customer with CPF '%s' does not exists!", cpf));
	}

	@Override
	public Customer getByUserId(String userId) {
		Optional<Customer> optionalCustomer = repository.findByUserId(userId);
		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		throw new NotFoundException(String.format("Could not find Customer with user id '%s'!", userId));
	}

	@Override
	public Customer updateCustomer(UpdateCustomerDto dto) {
		UUID id = dto.getCustomerId();
		Optional<Customer> optionalCustomer = repository.findById(id);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get(); 
			return repository.save(customer.updateEntity(dto));
		}
		
		throw new NotFoundException(String.format("Could not find Customer with id '%s'!", id));
	}
	
	@Override
	public Customer updateCustomer(UpdateKafkaCustomerDto dto) {
		String id = dto.getUserId();
		Optional<Customer> optionalCustomer = repository.findByUserId(id);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get(); 
			return repository.save(customer.updateEntity(dto));
		}
		
		throw new NotFoundException(String.format("Could not find Customer with id '%s'!", id));
	}

	@Override
	public String deleteCustomer(UUID id) {
		Optional<Customer> optionalCustomer = repository.findById(id);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			repository.delete(customer);
			
			return String.format("Customer '%s' deleted successfully!", customer.getName());
		}
		throw new NotFoundException(String.format("Could not find Customer with id '%s'!", id));
	}
	
	@Override
	public String deleteCustomerByUserId(String id) {
		Optional<Customer> optionalCustomer = repository.findByUserId(id);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			repository.delete(customer);
			
			return String.format("Customer '%s' deleted successfully!", customer.getName());
		}
		throw new NotFoundException(String.format("Could not find Customer with user id '%s'!", id));
	}

}
