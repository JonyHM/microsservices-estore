package br.gov.sp.fatec.model.dto.cart;

import java.util.Set;
import java.util.stream.Collectors;

import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.dto.orderProduct.ProductDto;

public class BaseCartDto {
	
	private String userId;
	private String cartId;
	private Set<ProductDto> products;
	
	public BaseCartDto() {}

	public BaseCartDto(
			String userId, 
			String cartId, 
			Set<ProductDto> products) {
		this.userId = userId;
		this.cartId = cartId;
		this.products = products;
	}
	
	public BaseCartDto(Cart cart) {
		this.userId = cart.getUserId();
		this.cartId = cart.getId().toString();
		this.products = cart.getProducts().stream().map(ProductDto::new).collect(Collectors.toSet());
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "BaseCartDto [userId=" + userId + 
				", cartId=" + cartId + 
				", products=" + products + "]";
	}
	
}
