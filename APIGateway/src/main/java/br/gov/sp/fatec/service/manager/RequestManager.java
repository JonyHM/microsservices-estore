package br.gov.sp.fatec.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import br.gov.sp.fatec.exceptions.NotFoundException;

@Service
public class RequestManager {

	@Autowired
	private WebClient client;
	
	public <T> ResponseEntity<T> doGET(String url, Class<T> type) {
		ResponseEntity<T> response;
		
		try {
			response = client
					.method(HttpMethod.GET)
					.uri(url)
					.retrieve()
					.toEntity(type)
					.block();
		} catch (WebClientResponseException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("Item not found", e);
			}
			throw new RuntimeException("Unknown error", e);
		}
		
		return response;
	}
	
	public <T, B> ResponseEntity<T> doPOST(String url, Class<T> type, B body) {
		ResponseEntity<T> response;
		try {
			response = client
					.method(HttpMethod.POST)
					.uri(url)
					.bodyValue(body)
					.retrieve()
					.toEntity(type)
					.block();
		} catch (WebClientResponseException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("Item not found", e);
			}
			throw new RuntimeException("Unknown error", e);
		}
			
		return response;
	}
	
	public <T, B> ResponseEntity<T> doPATCH(String url, Class<T> type, B body) {
		ResponseEntity<T> response;
		
		try {
			response = client
					.method(HttpMethod.PATCH)
					.uri(url)
					.bodyValue(body)
					.retrieve()
					.toEntity(type)
					.block();
		} catch (WebClientResponseException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("Item not found", e);
			}
			throw new RuntimeException("Unknown error", e);
		}
		return response;
	}
	
	public <T> ResponseEntity<T> doDELETE(String url, Class<T> type) {
		ResponseEntity<T> response;
		
		try {
			response = client
					.method(HttpMethod.DELETE)
					.uri(url)
					.retrieve()
					.toEntity(type)
					.block();
		} catch (WebClientResponseException e) {
			if(e.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("Item not found", e);
			}
			throw new RuntimeException("Unknown error", e);
		}
		return response;
	}
}
