package br.gov.sp.fatec.service.price;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;
import br.gov.sp.fatec.repository.PriceRepository;

@Service
public class PriceServiceImplement implements PriceService {
	
	@Autowired
	private PriceRepository repository;

	@Override
	public Set<Price> findPrices() {
		List<Price> prices = repository.findAll(); 
		return new HashSet<Price>(prices);
	}

	@Override
	public Price findPrice(UUID id) {
		Optional<Price> optionalPrice = repository.findById(id);
		return optionalPrice.orElseThrow(
			() -> new NotFoundException(String.format("Could not find Price with id '%s'", id))
		);
	}

	@Override
	public Price createPrice(CreatePriceDto dto) {
		Price price = new Price(dto);
		return repository.save(price);
	}

	@Override
	public Price updatePrice(UpdatePriceDto dto) {
		UUID id = dto.getId();
		Optional<Price> optionalPrice = repository.findById(id);
		
		Price price = optionalPrice.orElseThrow(
			() -> new NotFoundException(String.format("Could not find Price with id '%s'", id))
		);		
		price = price.updateEntity(dto);
		
		return repository.save(price);
	}

}
