package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;

public class CreateCartDto {

	private Set<CreateProductDto> products;
	private CreateOrderPriceDto totalValue;
	private UUID userId;
	
	public CreateCartDto() {}

	public CreateCartDto(
			Set<CreateProductDto> products, 
			CreateOrderPriceDto totalValue, 
			UUID userId) {
		this.products = products;
		this.totalValue = totalValue;
		this.userId = userId;
	}

	public Set<CreateProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<CreateProductDto> products) {
		this.products = products;
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
		return "CreateCartDto [products=" + products + 
				", totalValue=" + totalValue +
				", userId=" + userId + "]";
	}
	
}
