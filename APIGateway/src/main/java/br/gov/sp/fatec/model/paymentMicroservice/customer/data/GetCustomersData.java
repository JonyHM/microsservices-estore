package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CustomerDto;

public class GetCustomersData {
	
	private Set<CustomerDto> getCustomers;

	public GetCustomersData() {}

	public GetCustomersData(Set<CustomerDto> getCustomers) {
		this.getCustomers = getCustomers;
	}

	public Set<CustomerDto> getGetCustomers() {
		return getCustomers;
	}

	public void setGetCustomers(Set<CustomerDto> getCustomers) {
		this.getCustomers = getCustomers;
	}

	@Override
	public String toString() {
		return "GetCustomersData [getCustomers=" + getCustomers + "]";
	}
	
}
