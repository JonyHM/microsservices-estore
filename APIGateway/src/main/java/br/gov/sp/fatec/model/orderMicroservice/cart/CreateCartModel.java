package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;

public class CreateCartModel {

	private Set<CreateProductDto> products;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private CreateOrderPriceDto totalValue;
	private UUID userId;
	
	public CreateCartModel() {}
	
	public CreateCartModel(CreateCartDto dto) {
		this.products = dto.getProducts();
		this.createdDate = new Timestamp(System.currentTimeMillis());
		this.updatedDate = new Timestamp(System.currentTimeMillis());;
		this.totalValue = dto.getTotalValue();
		this.userId = dto.getUserId();
	}

	public CreateCartModel(
			Set<CreateProductDto> products, 
			Timestamp createdDate, 
			Timestamp updatedDate,
			CreateOrderPriceDto totalValue, 
			UUID userId) {
		this.products = products;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalValue = totalValue;
		this.userId = userId;
	}

	public Set<CreateProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<CreateProductDto> products) {
		this.products = products;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public CreateOrderPriceDto getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(CreateOrderPriceDto totalValue) {
		this.totalValue = totalValue;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreateCartModel [products=" + products + 
				", createdDate=" + createdDate + 
				", updatedDate=" + updatedDate + 
				", totalValue=" + totalValue + 
				", userId=" + userId + "]";
	}
	
}
