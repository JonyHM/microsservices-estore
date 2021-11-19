package br.gov.sp.fatec.model.paymentMicroservice.order.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.OrderDto;

public class GetOrdersData {

	private Set<OrderDto> getOrders;
	
	public GetOrdersData() {}

	public GetOrdersData(Set<OrderDto> getOrders) {
		this.getOrders = getOrders;
	}

	public Set<OrderDto> getGetOrders() {
		return getOrders;
	}

	public void setGetOrders(Set<OrderDto> getOrders) {
		this.getOrders = getOrders;
	}

	@Override
	public String toString() {
		return "GetOrdersData [getOrders=" + getOrders + "]";
	}
	
}
