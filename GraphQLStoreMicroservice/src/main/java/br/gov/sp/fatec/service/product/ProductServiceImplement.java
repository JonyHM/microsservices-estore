package br.gov.sp.fatec.service.product;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.model.dto.cart.BaseCartDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.product.CreateProductDto;
import br.gov.sp.fatec.model.dto.product.ProductDto;
import br.gov.sp.fatec.model.dto.product.UpdateProductDto;
import br.gov.sp.fatec.repository.PriceRepository;
import br.gov.sp.fatec.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private PriceRepository priceRepository;

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
		Product product = new Product(dto);
		Price price = new Price(dto.getPrice());
		price = priceRepository.save(price);
		product.setPrice(price);
		return repository.save(product);
	}

	@Override
	public Product updateProduct(UpdateProductDto dto) {
		UUID id = dto.getId();
		Optional<Product> optionalProduct = repository.findById(id);
		
		if(optionalProduct.isPresent()) {
			Product foundProduct = optionalProduct.get();
			Price price = foundProduct.getPrice();
			price = priceRepository.save(price.updateEntity(dto.getPrice()));
			foundProduct.setPrice(price);
						
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

	@Override
	@Transactional
	public void reserveProduct(StartOrderDto dto) {
		for(ProductDto productDto : dto.getProducts()) {
			UUID productId = productDto.getProductId();
			Optional<Product> optionalProduct = repository.findById(productId);
			
			Product product = optionalProduct.orElseThrow(
				() -> new NotFoundException(String.format("Could not find product with id '%s'", productId))
			);
			product.addUnavailableQuantity(productDto.getQuantity());
			repository.save(product);
		}
	}

	@Override
	public void updatePaidProducts(BaseCartDto dto) {
		if(dto.getProducts().size() > 0) {
			for (ProductDto product : dto.getProducts()) {
				UUID id = product.getProductId();
				Optional<Product> optionalProduct = repository.findById(id);
				
				Product foundProduct = optionalProduct.orElseThrow(
					() -> new NotFoundException(String.format("Could not find product with id '%s'", id))
				);
				
				foundProduct.updatePaidCartProduct(product.getQuantity());
				repository.save(foundProduct);
			}
		}
	}
	
	@Override
	public void updateCanceledProducts(BaseCartDto dto) {
		if(dto.getProducts().size() > 0) {
			for (ProductDto product : dto.getProducts()) {
				UUID id = product.getProductId();
				Optional<Product> optionalProduct = repository.findById(id);
				
				Product foundProduct = optionalProduct.orElseThrow(
					() -> new NotFoundException(String.format("Could not find product with id '%s'", id))
				);
				
				foundProduct.updateCanceledCartProduct(product.getQuantity());
				repository.save(foundProduct);
			}
		}
	}
}
