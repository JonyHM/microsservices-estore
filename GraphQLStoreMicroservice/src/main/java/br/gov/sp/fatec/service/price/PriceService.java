package br.gov.sp.fatec.service.price;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;

public interface PriceService {

	public Set<Price> getPrices();
	public Price getPriceById(UUID id);
	public Price getPriceByProductId(UUID productId);
	public Price createPrice(CreatePriceDto dto);
	public Price updatePrice(UpdatePriceDto dto);
	public String deletePrice(UUID priceId);
}