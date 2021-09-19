package br.gov.sp.fatec.service.attribute;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Attribute;
import br.gov.sp.fatec.model.Product;
import br.gov.sp.fatec.model.dto.attribute.CreateAttributeDto;
import br.gov.sp.fatec.model.dto.attribute.UpdateAttributeDto;
import br.gov.sp.fatec.repository.AttributeRepository;
import br.gov.sp.fatec.repository.ProductRepository;

@Service
public class AttributeServiceImplement implements AttributeService {
	
	@Autowired
	private AttributeRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Set<Attribute> getAttributes() {
		List<Attribute> attributes = repository.findAll();
		return new HashSet<Attribute>(attributes);
	}

	@Override
	public Attribute getAttributeById(UUID id) {
		Optional<Attribute> optionalAttribute = repository.findById(id);
		
		if(optionalAttribute.isPresent()) {
			return optionalAttribute.get();
		}
		
		throw new NotFoundException(String.format("Could not find Attribute with id '%s'", id));
	}

	@Override
	public Set<Attribute> getAttributesByProductId(UUID productId) {
		Optional<Set<Attribute>> optionalAttribute = repository.findByProductId(productId);
		
		if(optionalAttribute.isPresent()) {
			return optionalAttribute.get();
		}
		
		throw new NotFoundException(String.format("Could not find Attribute for Product with id '%s'", productId));
	}

	@Override
	public Attribute createAttribute(CreateAttributeDto dto) {
		UUID productId = dto.getProductId();
		Optional<Product> optionalProduct = productRepository.findById(productId);
		Attribute attribute = new Attribute(dto);
		
		if(optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			attribute.setProduct(product);
			attribute = repository.save(attribute);
			
			product.getAttributes().add(attribute);
			productRepository.save(product);
			return attribute;
		}
		
		throw new NotFoundException(String.format("Could not Product with id '%s'", productId));
	}

	@Override
	public Attribute updateAttribute(UpdateAttributeDto dto) {
		UUID id = dto.getAttributeId();
		Optional<Attribute> optionalAttribute = repository.findById(id);
		
		
		if(optionalAttribute.isPresent()) {
			Attribute attribute = optionalAttribute.get();
			return attribute.updateEntity(dto);
		}
		
		throw new NotFoundException(String.format("Could not find Attribute with id '%s'", id));
	}

	@Override
	public String deleteAttribute(UUID id) {
		Optional<Attribute> optionalAttribute = repository.findById(id);
		
		if(optionalAttribute.isPresent()) {
			Attribute attribute = optionalAttribute.get();
			repository.delete(attribute);
			return String.format("Attribute '%s' deleted successfully!", attribute.getName());
		}
		
		throw new NotFoundException(String.format("Could not find Attribute with id '%s'", id));
	}

}
