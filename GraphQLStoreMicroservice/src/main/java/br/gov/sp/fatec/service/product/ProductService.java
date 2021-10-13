package br.gov.sp.fatec.service.product;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.model.dto.cart.BaseCartDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.product.CreateProductDto;
import br.gov.sp.fatec.model.dto.product.UpdateProductDto;

public interface ProductService {
	
	public Set<Product> getProducts();
	public Product getProductById(UUID id); 
	public Product createProduct(CreateProductDto dto);
	public Product updateProduct(UpdateProductDto dto);
	public String deleteProduct(UUID id);
	
	public void reserveProduct(StartOrderDto dto);
	public void updatePaidProducts(BaseCartDto dto);
	public void updateCanceledProducts(BaseCartDto dto);
}
