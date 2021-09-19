package br.gov.sp.fatec.service.product;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.model.dto.product.CreateProductDto;
import br.gov.sp.fatec.model.dto.product.UpdateProductDto;
import br.gov.sp.fatec.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Override
	public Set<Product> getProducts() {
		List<Product> products = repository.findAll();
		return new HashSet<Product>(products);
	}

	@Override
	public Product getProductById(UUID id) {
		Optional<Product> optionalProduct = repository.findById(id);
		
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		
		throw new NotFoundException(String.format("Could not find product with id '%s'", id));
	}

	@Override
	public Product createProduct(CreateProductDto dto) {
		Product newProduct = new Product(dto);
		return repository.save(newProduct);
	}

	@Override
	public Product updateProduct(UpdateProductDto dto) {
		UUID id = dto.getId();
		Optional<Product> optionalProduct = repository.findById(id);
		
		if(optionalProduct.isPresent()) {
			Product foundProduct = optionalProduct.get();
						
			return repository.save(foundProduct.updateEntity(dto));
		}
		
		throw new NotFoundException(String.format("Could not find product with id '%s'", id));
	}

	@Override
	public String deleteProduct(UUID id) {
		Optional<Product> optionalProduct = repository.findById(id);
		
		if(optionalProduct.isPresent()) {
			Product foundProduct = optionalProduct.get();
			repository.delete(foundProduct);
			
			return String.format("Product '%s' deleted successfully", foundProduct.getName()); 
		}
		
		throw new NotFoundException(String.format("Could not find product with id '%s'", id));
	}

}
