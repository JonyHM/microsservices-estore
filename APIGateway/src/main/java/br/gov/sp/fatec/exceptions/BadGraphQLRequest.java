package br.gov.sp.fatec.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Error sending request to GraphQL endpoint") 
public class BadGraphQLRequest extends RuntimeException {

	private static final long serialVersionUID = 2435368830133433293L;

	public BadGraphQLRequest(String message) {
		super(message);
	}
	
	public BadGraphQLRequest(Throwable reason) {
		super(reason);
	}
	
	public BadGraphQLRequest(String message, Throwable reason) {
		super(message, reason);
	}
}
