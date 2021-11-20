package br.gov.sp.fatec.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.orderMicroservice.cart.AddProductDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.CartDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.CreateCartDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.CreateCartModel;
import br.gov.sp.fatec.model.orderMicroservice.cart.RemoveProductDto;
import br.gov.sp.fatec.model.orderMicroservice.cart.UpdateCartDto;
import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.price.UpdateOrderPriceDto;
import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;
import br.gov.sp.fatec.model.orderMicroservice.product.ProductDto;
import br.gov.sp.fatec.model.orderMicroservice.product.UpdateProductDto;
import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;
import br.gov.sp.fatec.service.manager.RequestManager;

@Service
public class OrderService {

	@Value("${service.order.url}")
	private String urlString;
	
	@Autowired
	private RequestManager manager;
	
	/** PRICE **/
   
    public ResponseEntity<PriceDto[]> getPrices() {
    	String url = String.format("%s/price", urlString);
    	return manager.doGET(url, PriceDto[].class);
    }
    
    public ResponseEntity<PriceDto> getPriceById(UUID id) {
    	String url = String.format("%s/price/%s", urlString, id);
        return manager.doGET(url, PriceDto.class);
    }
    
    public ResponseEntity<PriceDto> createPrice(CreateOrderPriceDto dto) {
    	String url = String.format("%s/price", urlString);
        return manager.doPOST(url, PriceDto.class, dto);
    }
    
    public ResponseEntity<PriceDto> updatePrice(UpdateOrderPriceDto dto) {
    	String url = String.format("%s/price", urlString);
    	return manager.doPATCH(url, PriceDto.class, dto);
    }
    
    /** PRODUCT **/
    
    public ResponseEntity<ProductDto[]> getProducts() {
    	String url = String.format("%s/orderProduct", urlString);
    	return manager.doGET(url, ProductDto[].class);
    }
    
    public ResponseEntity<ProductDto> getProductById(UUID id) {
    	String url = String.format("%s/orderProduct/%s", urlString, id);
    	return manager.doGET(url, ProductDto.class);
    }
    
    public ResponseEntity<ProductDto> getProductByProductId(String id) {
    	String url = String.format("%s/orderProduct/findByProductId/%s", urlString, id);
        return manager.doGET(url, ProductDto.class);
    }
    
    public ResponseEntity<ProductDto> createProduct(CreateProductDto dto) {
    	String url = String.format("%s/orderProduct", urlString);
        return manager.doPOST(url, ProductDto.class, dto);
    }
    
    public ResponseEntity<ProductDto> updateProduct(UpdateProductDto dto) {
    	String url = String.format("%s/orderProduct", urlString);
    	return manager.doPATCH(url, ProductDto.class, dto);
    }
    
    public ResponseEntity<String> deleteProduct(UUID id) {
    	String url = String.format("%s/orderProduct/%s", urlString, id);
        return manager.doDELETE(url, String.class);
    }
    
    /** CART **/
    
    public ResponseEntity<CartDto[]> getCarts() {
    	String url = String.format("%s/cart", urlString);
    	return manager.doGET(url, CartDto[].class);
    }
    
    public ResponseEntity<CartDto> getCartById(UUID id) {
    	String url = String.format("%s/cart/%s", urlString, id);
    	return manager.doGET(url, CartDto.class);
    }
    
    public ResponseEntity<CartDto[]> getCartsByUser(String id) {
    	String url = String.format("%s/cart/findByUserId/%s", urlString, id);
    	return manager.doGET(url, CartDto[].class);
    }
    
    public ResponseEntity<CartDto> createCart(CreateCartDto dto) {
    	String url = String.format("%s/cart", urlString);
        return manager.doPOST(url, CartDto.class, new CreateCartModel(dto));
    }
    
    public ResponseEntity<CartDto> updateCart(UpdateCartDto dto) {
    	String url = String.format("%s/cart", urlString);
        return manager.doPATCH(url, CartDto.class, dto);
    }
    
    public ResponseEntity<CartDto> addProductToCart(AddProductDto dto) {
    	String url = String.format("%s/cart/addProduct", urlString);
        return manager.doPATCH(url, CartDto.class, dto);
    }
    
    public ResponseEntity<CartDto> removeProductToCart(RemoveProductDto dto) {
    	String url = String.format("%s/cart/removeProduct", urlString);
        return manager.doPATCH(url, CartDto.class, dto);
    }
    
    public ResponseEntity<String> deleteCart(UUID id) {
    	String url = String.format("%s/cart/%s", urlString, id);
        return manager.doDELETE(url, String.class);
    }
}
