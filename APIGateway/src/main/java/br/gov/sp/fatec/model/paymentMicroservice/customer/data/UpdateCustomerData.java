package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class UpdateCustomerData {

	private CustomerDto updateCustomer;
	
	public UpdateCustomerData() {}

	public UpdateCustomerData(CustomerDto updateCustomer) {
		this.updateCustomer = updateCustomer;
	}

	public CustomerDto getUpdateCustomer() {
		return updateCustomer;
	}

	public void setUpdateCustomer(CustomerDto updateCustomer) {
		this.updateCustomer = updateCustomer;
	}

	@Override
	public String toString() {
		return "UpdateCustomerData [updateCustomer=" + updateCustomer + "]";
	}
	
}
