package br.gov.sp.fatec.service.price;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;

public interface PriceService {

	public Set<Price> findPrices();
	public Price findPrice(UUID id);
	public Price createPrice(CreatePriceDto dto);
	public Price updatePrice(UpdatePriceDto dto);
	
}
