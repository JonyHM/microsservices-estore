package br.gov.sp.fatec.service.customer;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateCustomerDto;

public interface CustomerService {

	public List<Customer> getAll();
	public Customer getById(UUID id);
	public Customer getByCPF(String cpf);
	public Customer getByUserId(UUID userId);
	public Customer createCustomer(CreateCustomerDto dto);
	public Customer updateCustomer(UpdateCustomerDto dto);
	public String deleteCustomer(UUID id);
}
