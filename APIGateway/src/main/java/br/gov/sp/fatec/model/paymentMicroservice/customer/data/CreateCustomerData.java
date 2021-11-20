package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class CreateCustomerData {
	
	private CustomerDto createCustomer;
	
	public CreateCustomerData() {}

	public CreateCustomerData(CustomerDto createCustomer) {
		this.createCustomer = createCustomer;
	}

	public CustomerDto getCreateCustomer() {
		return createCustomer;
	}

	public void setCreateCustomer(CustomerDto createCustomer) {
		this.createCustomer = createCustomer;
	}

	@Override
	public String toString() {
		return "CreateCustomerData [createCustomer=" + createCustomer + "]";
	}

}
