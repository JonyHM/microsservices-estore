package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;

public class UpdateCartDto {

	private Set<CreateProductDto> products;
	private CreateOrderPriceDto totalValue;
	private UUID cartId;
	
	public UpdateCartDto() {}

	public UpdateCartDto(
			Set<CreateProductDto> products, 
			CreateOrderPriceDto totalValue, 
			UUID cartId) {
		this.products = products;
		this.totalValue = totalValue;
		this.cartId = cartId;
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

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "UpdateCartDto [products=" + products + 
				", totalValue=" + totalValue + 
				", cartId=" + cartId + "]";
	}
	
}
