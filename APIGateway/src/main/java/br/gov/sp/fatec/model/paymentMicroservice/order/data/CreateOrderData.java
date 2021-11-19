package br.gov.sp.fatec.model.paymentMicroservice.order.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.CreateOrderDto;

public class CreateOrderData {

	private CreateOrderDto createOrder;
	
	public CreateOrderData() {}

	public CreateOrderData(CreateOrderDto createOrder) {
		this.createOrder = createOrder;
	}

	public CreateOrderDto getCreateOrder() {
		return createOrder;
	}

	public void setCreateOrder(CreateOrderDto createOrder) {
		this.createOrder = createOrder;
	}

	@Override
	public String toString() {
		return "CreateOrderData [createOrder=" + createOrder + "]";
	}
	
}
