package br.gov.sp.fatec.model.paymentMicroservice.order.data;

public class CancelOrderData {

	private String cancelOrder;
	
	public CancelOrderData() {}

	public CancelOrderData(String cancelOrder) {
		this.cancelOrder = cancelOrder;
	}

	public String getCancelOrder() {
		return cancelOrder;
	}

	public void setCancelOrder(String cancelOrder) {
		this.cancelOrder = cancelOrder;
	}

	@Override
	public String toString() {
		return "CancelOrderData [cancelOrder=" + cancelOrder + "]";
	}
	
}
