package br.gov.sp.fatec.controller;

import java.text.MessageFormat;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.dto.cart.AddProductDto;
import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.dto.cart.RemoveProductDto;
import br.gov.sp.fatec.model.dto.cart.UpdateCartDto;
import br.gov.sp.fatec.model.view.View;
import br.gov.sp.fatec.service.cart.CartService;

@RestController
@RequestMapping(value = "cart")
@CrossOrigin
public class CartController {

	@Autowired
	private CartService service;
		
	@GetMapping
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Set<Cart>> findCarts() {
		Set<Cart> carts = service.findCarts();
		return ResponseEntity.ok(carts);
	}
	
	@GetMapping(value = "/findByUserId/{id}")
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Set<Cart>> findCartsForUserId(@PathVariable String id) {
		Set<Cart> carts = service.findCartsForUserId(id);
		return ResponseEntity.ok(carts);
	}
	
	@GetMapping(value = "/{id}")
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Cart> findCart(@PathVariable UUID id) {
		Cart cart = service.findCart(id);
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Cart> createCart(
			@RequestBody CreateCartDto dto, 
			UriComponentsBuilder builder) {
		Cart cart = service.createCart(dto);
		HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(
    		builder.path(MessageFormat.format("/cart/{0}", cart.getId())).build().toUri()
    	);
    	
		return ResponseEntity.created(headers.getLocation()).body(cart);
	}
	
	@PatchMapping
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Cart> updateCart(@RequestBody UpdateCartDto dto) {
		Cart cart = service.updateCart(dto);
		return ResponseEntity.ok(cart);
	}
	
	@PatchMapping(value = "/addProduct")
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Cart> addProductToCart(@RequestBody AddProductDto dto) {
		Cart cart = service.addProductToCart(dto);
		return ResponseEntity.ok(cart);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteCart(@PathVariable UUID id) {
		String response = service.deleteCart(id);
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping(value = "/removeProduct")
	@JsonView(value = View.Cart.class)
	public ResponseEntity<Cart> removeOrderProductFromCart(@RequestBody RemoveProductDto dto) {
		Cart cart = service.removeOrderProductFromCart(dto);
		return ResponseEntity.ok(cart);
	}
}
