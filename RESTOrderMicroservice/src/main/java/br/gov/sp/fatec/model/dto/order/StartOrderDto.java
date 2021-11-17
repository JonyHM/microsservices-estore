package br.gov.sp.fatec.model.dto.order;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.dto.orderProduct.ProductDto;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;

public class StartOrderDto {

	private String userId;
	private UUID cartId;
	private Set<ProductDto> products;
	private String description;
	private CreatePriceDto price;
	
	public StartOrderDto() {}
	
	public StartOrderDto(Cart cart) {
		this.userId = cart.getUserId();
		this.cartId = cart.getId();
		this.description = String.format("Cart created at %s", cart.getCreatedDate());
		this.products = cart.getProducts().stream().map(ProductDto::new).collect(Collectors.toSet());
		this.price = new CreatePriceDto(cart.getTotalValue());
	}

	public StartOrderDto(
			String userId, 
			UUID cartId,
			String description, 
			Set<ProductDto> products,
			CreatePriceDto price) {
		this.userId = userId;
		this.cartId = cartId;
		this.description = description;
		this.products = products;
		this.price = price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

	public CreatePriceDto getPrice() {
		return price;
	}

	public void setPrice(CreatePriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CreateCustomerDto [userId=" + userId +
				", cartId=" + cartId + 
				", description=" + description + 
				", products=" + products + 
				", price=" + price + "]";
	}
	
}
