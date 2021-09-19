package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.model.dto.product.CreateProductDto;
import br.gov.sp.fatec.model.dto.product.UpdateProductDto;
import br.gov.sp.fatec.service.product.ProductService;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class ProductMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ProductService service;
	
	public Product createProduct(CreateProductDto product) {
		return service.createProduct(product);
	}
	
	public Product updateProduct(UpdateProductDto product) {
		return service.updateProduct(product);
	}
	
	public String deleteProduct(UUID productId) {
		return service.deleteProduct(productId);
	}
}
