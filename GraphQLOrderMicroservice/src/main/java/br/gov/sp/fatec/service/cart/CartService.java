package br.gov.sp.fatec.service.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.dto.cart.UpdateCartDto;

public interface CartService {

	public Set<Cart> findCarts();
	public Set<Cart> findCartsForUserId(UUID userId);
	public Cart findCart(UUID id);
	public Cart createCart(CreateCartDto dto);
	public Cart updateCart(UpdateCartDto dto);
	public String deleteCart(UUID id);
}
