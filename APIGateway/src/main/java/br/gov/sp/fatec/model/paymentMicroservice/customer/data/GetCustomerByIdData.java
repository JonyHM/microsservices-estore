package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class GetCustomerByIdData {

	private CustomerDto getCustomerById;
	
	public GetCustomerByIdData() {}

	public GetCustomerByIdData(CustomerDto getCustomerById) {
		this.getCustomerById = getCustomerById;
	}

	public CustomerDto getGetCustomerById() {
		return getCustomerById;
	}

	public void setGetCustomerById(CustomerDto getCustomerById) {
		this.getCustomerById = getCustomerById;
	}

	@Override
	public String toString() {
		return "GetCustomerByIdData [getCustomerById=" + getCustomerById + "]";
	}
	
}
