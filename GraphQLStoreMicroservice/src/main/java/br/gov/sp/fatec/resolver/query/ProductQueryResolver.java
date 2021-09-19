package br.gov.sp.fatec.resolver.query;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.service.product.ProductService;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class ProductQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private ProductService service;
	
	public Set<Product> getProducts() {
		return service.getProducts();
	}
	
	public Product getProductById(UUID id) {
		return service.getProductById(id);
	}
}
