package br.gov.sp.fatec.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Resource or content not found")
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4942301601077827593L;

	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(Throwable reason) {
		super(reason);
	}
	
	public NotFoundException(String message, Throwable reason) {
		super(message, reason);
	}
}
