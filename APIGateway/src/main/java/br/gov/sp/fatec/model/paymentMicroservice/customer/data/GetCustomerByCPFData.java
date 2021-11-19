package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class GetCustomerByCPFData {

	private CustomerDto getCustomerByCPF;
	
	public GetCustomerByCPFData() {}

	public GetCustomerByCPFData(CustomerDto getCustomerByCPF) {
		this.getCustomerByCPF = getCustomerByCPF;
	}

	public CustomerDto getGetCustomerByCPF() {
		return getCustomerByCPF;
	}

	public void setGetCustomerByCPF(CustomerDto getCustomerByCPF) {
		this.getCustomerByCPF = getCustomerByCPF;
	}

	@Override
	public String toString() {
		return "GetCustomerByCPFData [getCustomerByCPF=" + getCustomerByCPF + "]";
	}
	
}
