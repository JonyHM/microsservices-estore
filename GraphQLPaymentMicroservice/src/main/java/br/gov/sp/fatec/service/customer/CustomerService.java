package br.gov.sp.fatec.service.customer;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.CreateCustomerDto;
import javassist.NotFoundException;

public interface CustomerService {

	public List<Customer> getAll();
	public Customer createCustomer(CreateCustomerDto customer);
	public Customer getById(UUID id) throws NotFoundException;
	public Customer getByCPF(String cpf) throws NotFoundException;
	public Customer getByUserId(UUID userId) throws NotFoundException;
}
