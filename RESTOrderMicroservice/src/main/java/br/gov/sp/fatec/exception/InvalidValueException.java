package br.gov.sp.fatec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class InvalidValueException extends RuntimeException {

	private static final long serialVersionUID = -8116427174126581302L;

	public InvalidValueException() {
		super();
	}
	
	public InvalidValueException(String msg) {
		super(msg);
	}
}
