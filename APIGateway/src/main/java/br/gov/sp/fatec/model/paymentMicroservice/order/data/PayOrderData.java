package br.gov.sp.fatec.model.paymentMicroservice.order.data;

public class PayOrderData {
	
	private String payOrder;
	
	public PayOrderData() {}

	public PayOrderData(String payOrder) {
		this.payOrder = payOrder;
	}

	public String getPayOrder() {
		return payOrder;
	}

	public void setPayOrder(String payOrder) {
		this.payOrder = payOrder;
	}

	@Override
	public String toString() {
		return "PayOrderData [payOrder=" + payOrder + "]";
	}

}
