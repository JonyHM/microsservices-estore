package br.gov.sp.fatec.model.paymentMicroservice.order.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.OrderDto;

public class UpdateOrderData {

	private OrderDto updateOrder;
	
	public UpdateOrderData() {}

	public UpdateOrderData(OrderDto updateOrder) {
		this.updateOrder = updateOrder;
	}

	public OrderDto getUpdateOrder() {
		return updateOrder;
	}

	public void setUpdateOrder(OrderDto updateOrder) {
		this.updateOrder = updateOrder;
	}

	@Override
	public String toString() {
		return "UpdateOrderData [updateOrder=" + updateOrder + "]";
	}
	
}
