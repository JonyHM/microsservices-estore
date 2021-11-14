package br.gov.sp.fatec.model.paymentMicroservice.order.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.OrderDto;

public class GetOrderByIdData {

	private OrderDto getOrderById;
	
	public GetOrderByIdData() {}

	public GetOrderByIdData(OrderDto getOrderById) {
		this.getOrderById = getOrderById;
	}

	public OrderDto getGetOrderById() {
		return getOrderById;
	}

	public void setGetOrderById(OrderDto getOrderById) {
		this.getOrderById = getOrderById;
	}

	@Override
	public String toString() {
		return "GetOrderByIdData [getOrderById=" + getOrderById + "]";
	}
	
}
