package br.gov.sp.fatec.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.gov.sp.fatec.model.orderMicroservice.cart.AddProductDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.CartDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.CreateCartDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.RemoveProductDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.UpdateCartDto;
import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.price.UpdateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;
import br.gov.sp.fatec.model.orderMicroservice.product.ProductDto;
import br.gov.sp.fatec.model.orderMicroservice.product.UpdateProductDto;
import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;
import br.gov.sp.fatec.service.OrderService;

@RestController
@RequestMapping(value = "order")
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService service;
	
	/** PRICE **/

	@GetMapping(value = "price")
    public ResponseEntity<PriceDto[]> getPrices() { 
		ResponseEntity<PriceDto[]> response = service.getPrices();
    	return response;
    }
    
    @GetMapping(value = "price/{id}")
    public ResponseEntity<PriceDto> getPriceById(@PathVariable UUID id) { 
    	ResponseEntity<PriceDto> response = service.getPriceById(id);
    	return response;
    }
     
    @PostMapping(value = "price")
    public ResponseEntity<PriceDto> createPrice(@RequestBody CreateOrderPriceDto dto) { 
    	ResponseEntity<PriceDto> response = service.createPrice(dto);
    	return response;
    }
    
    @PatchMapping(value = "price")
    public ResponseEntity<PriceDto> updatePrice(@RequestBody UpdateOrderPriceDto dto) { 
    	ResponseEntity<PriceDto> response = service.updatePrice(dto);
    	return response;
    }
    
    /** PRODUCT **/

    @GetMapping(value = "product")
    public ResponseEntity<ProductDto[]> getProducts() { 
		ResponseEntity<ProductDto[]> response = service.getProducts();
    	return response;
    }
    
    @GetMapping(value = "product/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable UUID id) { 
		ResponseEntity<ProductDto> response = service.getProductById(id);
    	return response;
    }
    
    @GetMapping(value = "product/by-pid/{id}")
    public ResponseEntity<ProductDto> getProductByProductId(@PathVariable String id) { 
		ResponseEntity<ProductDto> response = service.getProductByProductId(id);
    	return response;
    }
    
    @PostMapping(value = "product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto dto) { 
    	ResponseEntity<ProductDto> response = service.createProduct(dto);
    	return response;
    }
    
    @PatchMapping(value = "product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody UpdateProductDto dto) { 
    	ResponseEntity<ProductDto> response = service.updateProduct(dto);
    	return response;
    }
    
    @DeleteMapping(value = "product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) { 
    	ResponseEntity<String> response = service.deleteProduct(id);
    	return response;
    }
    
    /** CART **/

    @GetMapping(value = "cart")
    public ResponseEntity<CartDto[]> getCarts() { 
		ResponseEntity<CartDto[]> response = service.getCarts();
    	return response;
    }
    
    @GetMapping(value = "cart/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable UUID id) { 
		ResponseEntity<CartDto> response = service.getCartById(id);
    	return response;
    }
    
    @GetMapping(value = "cart/by-user/{id}")
    public ResponseEntity<CartDto[]> getCartsByUser(@PathVariable String id) { 
		ResponseEntity<CartDto[]> response = service.getCartsByUser(id);
    	return response;
    }
    
    @PostMapping(value = "cart")
    public ResponseEntity<CartDto> createCart(@RequestBody CreateCartDto dto) { 
    	ResponseEntity<CartDto> response = service.createCart(dto);
    	return response;
    }
    
    @PatchMapping(value = "cart")
    public ResponseEntity<CartDto> updateCart(@RequestBody UpdateCartDto dto) { 
    	ResponseEntity<CartDto> response = service.updateCart(dto);
    	return response;
    }
    
    @PatchMapping(value = "cart/add-product")
    public ResponseEntity<CartDto> addProductToCart(@RequestBody AddProductDto dto) { 
    	ResponseEntity<CartDto> response = service.addProductToCart(dto);
    	return response;
    }
    
    @PatchMapping(value = "cart/remove-product")
    public ResponseEntity<CartDto> removeProductToCart(@RequestBody RemoveProductDto dto) { 
    	ResponseEntity<CartDto> response = service.removeProductToCart(dto);
    	return response;
    }
    
    @DeleteMapping(value = "cart/{id}")
    public ResponseEntity<String> deleteCart(@PathVariable UUID id) { 
    	ResponseEntity<String> response = service.deleteCart(id);
    	return response;
    }
}
