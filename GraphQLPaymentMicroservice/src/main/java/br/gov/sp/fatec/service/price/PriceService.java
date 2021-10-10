package br.gov.sp.fatec.service.price;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;

public interface PriceService {

	public List<Price> getAll();
	public Price getById(UUID id);
	public Price getByOrderId(UUID orderId);
	public Price createPrice(CreatePriceDto dto);
	public Price updatePrice(UpdatePriceDto dto);
	public String deletePrice(UUID id);
}
