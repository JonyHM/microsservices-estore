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

import br.gov.sp.fatec.model.OrderProduct;
import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.orderProduct.UpdateOrderProductDto;
import br.gov.sp.fatec.model.view.View;
import br.gov.sp.fatec.service.order.OrderProductService;

@RestController
@RequestMapping(value = "orderProduct")
@CrossOrigin
public class OrderProductController {

	@Autowired
	private OrderProductService service;
	
	@GetMapping
	@JsonView(value = View.Product.class)
	public ResponseEntity<Set<OrderProduct>> findOrderProducts() {
		Set<OrderProduct> orderProducts = service.findOrderProducts();
		return ResponseEntity.ok(orderProducts);
	}
	
	@GetMapping(value = "/findByProductId/{id}")
	@JsonView(value = View.Product.class)
	public ResponseEntity<OrderProduct> findOrderProductForProductId(@PathVariable String id) {
		OrderProduct orderProduct = service.findOrderProductForProductId(id);
		return ResponseEntity.ok(orderProduct);
	}
	
	@GetMapping(value = "/{id}")
	@JsonView(value = View.Product.class)
	public ResponseEntity<OrderProduct> findOrderProduct(@PathVariable UUID id) {
		OrderProduct orderProduct = service.findOrderProduct(id);
		return ResponseEntity.ok(orderProduct);
	}
	
	@PostMapping
	@JsonView(value = View.Product.class)
	public ResponseEntity<OrderProduct> createOrderProduct(
			@RequestBody CreateOrderProductDto dto,
			UriComponentsBuilder builder) {
		OrderProduct orderProduct = service.createOrderProduct(dto);
		HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(
    		builder.path(MessageFormat.format("/orderProduct/{0}", orderProduct.getId())).build().toUri()
    	);
    	
		return ResponseEntity.created(headers.getLocation()).body(orderProduct);
	}
	
	@PatchMapping
	@JsonView(value = View.Product.class)
	public ResponseEntity<OrderProduct> updateOrderProduct(@RequestBody UpdateOrderProductDto dto) {
		OrderProduct orderProduct = service.updateOrderProduct(dto);
		return ResponseEntity.ok(orderProduct);
	}
	
	@DeleteMapping(value = "/{id}")
	@JsonView(value = View.Product.class)
	public ResponseEntity<String> deleteOrderProduct(@PathVariable UUID id) {
		String response = service.deleteOrderProduct(id);
		return ResponseEntity.ok(response);
	}
}
