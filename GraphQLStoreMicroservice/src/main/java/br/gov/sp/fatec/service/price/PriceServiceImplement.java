package br.gov.sp.fatec.service.price;

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
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;
import br.gov.sp.fatec.repository.PriceRepository;
import br.gov.sp.fatec.repository.ProductRepository;

@Service
public class PriceServiceImplement implements PriceService {
	
	@Autowired
	private PriceRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Set<Price> getPrices() {
		List<Price> prices = repository.findAll();
		return new HashSet<Price>(prices);
	}

	@Override
	public Price getPriceById(UUID id) {
		Optional<Price> optionalPrice = repository.findById(id);
		
		if(optionalPrice.isPresent()) {
			return optionalPrice.get();
		}
		
		throw new NotFoundException(String.format("Could not find Price with id '%s'", id));
	}

	@Override
	public Price getPriceByProductId(UUID productId) {
		Optional<Price> optionalPrice = repository.findByProductId(productId);
		
		if(optionalPrice.isPresent()) {
			return optionalPrice.get();
		}
		
		throw new NotFoundException(String.format("Could not find Price for product with id '%s'", productId));
	}

	@Override
	@Transactional
	public Price createPrice(CreatePriceDto dto) {
		UUID productId = dto.getProductId();
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Price price = new Price(dto);
		
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			price.setProduct(product);
			price = repository.save(price);
			
			product.setPrice(price);
			productRepository.save(product);
			return price;
		}
		
		throw new NotFoundException(String.format("Could not find Product with id '%s'", productId));
	}

	@Override
	public Price updatePrice(UpdatePriceDto dto) {
		UUID id = dto.getPriceId();
		Optional<Price> optionalPrice = repository.findById(id);

		if(optionalPrice.isPresent()) {
			Price price = optionalPrice.get(); 
			return price.updateEntity(dto);
		}
		
		throw new NotFoundException(String.format("Could not find Price with id '%s'", id));
	}

	@Override
	public String deletePrice(UUID priceId) {
		Optional<Price> optionalPrice = repository.findById(priceId);

		if(optionalPrice.isPresent()) {
			Price price = optionalPrice.get(); 
			repository.delete(price);
			return String.format("Price with id '%s' deleted successfully!", priceId);
		}
		
		throw new NotFoundException(String.format("Could not find Price with id '%s'", priceId));
	}
}
