package br.gov.sp.fatec.model.paymentMicroservice.order.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.OrderDto;

public class GetOrdersByCustomerIdData {

	private Set<OrderDto> getOrdersByCustomerId;
	
	public GetOrdersByCustomerIdData() {}

	public GetOrdersByCustomerIdData(Set<OrderDto> getOrdersByCustomerId) {
		this.getOrdersByCustomerId = getOrdersByCustomerId;
	}

	public Set<OrderDto> getGetOrdersByCustomerId() {
		return getOrdersByCustomerId;
	}

	public void setGetOrdersByCustomerId(Set<OrderDto> getOrdersByCustomerId) {
		this.getOrdersByCustomerId = getOrdersByCustomerId;
	}

	@Override
	public String toString() {
		return "GetOrdersByCustomerIdData [getOrdersByCustomerId=" + getOrdersByCustomerId + "]";
	}
	
}
