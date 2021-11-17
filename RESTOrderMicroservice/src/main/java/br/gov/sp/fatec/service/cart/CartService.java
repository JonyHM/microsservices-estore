package br.gov.sp.fatec.service.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.dto.cart.AddProductDto;
import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.dto.cart.RemoveProductDto;
import br.gov.sp.fatec.model.dto.cart.UpdateCartDto;
import br.gov.sp.fatec.model.dto.order.KafkaOrderDto;

public interface CartService {

	public Set<Cart> findCarts();
	public Set<Cart> findCartsForUserId(String userId);
	public Cart findCart(UUID id);
	public Cart createCart(CreateCartDto dto);
	public Cart updateCart(UpdateCartDto dto);
	public Cart addProductToCart(AddProductDto dto);
	public String deleteCart(UUID id);
	public Cart removeOrderProductFromCart(RemoveProductDto dto);
	
	public void updatePaidCart(KafkaOrderDto dto);
	public void updateCanceledCart(KafkaOrderDto dto);
}
