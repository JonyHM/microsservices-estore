package br.gov.sp.fatec.model.dto.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;

public class UpdateCartDto {

	private Set<CreateOrderProductDto> products;
	private CreatePriceDto totalValue;
	private UUID cartId;
	
	public UpdateCartDto() {}

	public UpdateCartDto(
			Set<CreateOrderProductDto> products,
			CreatePriceDto totalValue,
			UUID cartId) {
		this.products = products;
		this.totalValue = totalValue;
		this.cartId = cartId;
	}

	public Set<CreateOrderProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<CreateOrderProductDto> products) {
		this.products = products;
	}

	public CreatePriceDto getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(CreatePriceDto totalValue) {
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
