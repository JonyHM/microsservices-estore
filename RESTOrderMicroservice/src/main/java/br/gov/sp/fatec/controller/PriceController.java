package br.gov.sp.fatec.controller;

import java.text.MessageFormat;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;
import br.gov.sp.fatec.service.price.PriceService;

@RestController
@RequestMapping(value = "price")
@CrossOrigin
public class PriceController {

	@Autowired
	private PriceService service;
	
	@GetMapping
	public ResponseEntity<Set<Price>> findPrices() {
		Set<Price> prices = service.findPrices();
		return ResponseEntity.ok(prices);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Price> findPrice(@PathVariable UUID id) {
		Price price = service.findPrice(id);
		return ResponseEntity.ok(price);
	}
	
	@PostMapping
	public ResponseEntity<Price> createPrice(
			@RequestBody CreatePriceDto dto,
			UriComponentsBuilder builder) {
		Price price = service.createPrice(dto);
		HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(
    		builder.path(MessageFormat.format("/price/{0}", price.getId())).build().toUri()
    	);
    	
		return ResponseEntity.created(headers.getLocation()).body(price);
	}
	
	@PatchMapping
	public ResponseEntity<Price> updatePrice(@RequestBody UpdatePriceDto dto) {
		Price price = service.updatePrice(dto);
		return ResponseEntity.ok(price);
	}
	
}
