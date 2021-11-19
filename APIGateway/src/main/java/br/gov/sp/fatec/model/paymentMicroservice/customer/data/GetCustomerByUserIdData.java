package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class GetCustomerByUserIdData {

	private CustomerDto getCustomerByUserId;
	
	public GetCustomerByUserIdData() {}

	public GetCustomerByUserIdData(CustomerDto getCustomerByUserId) {
		this.getCustomerByUserId = getCustomerByUserId;
	}

	public CustomerDto getGetCustomerByUserId() {
		return getCustomerByUserId;
	}

	public void setGetCustomerByUserId(CustomerDto getCustomerByUserId) {
		this.getCustomerByUserId = getCustomerByUserId;
	}

	@Override
	public String toString() {
		return "GetCustomerByUserId [getCustomerByUserId=" + getCustomerByUserId + "]";
	}
	
}
