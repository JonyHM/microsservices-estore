package br.gov.sp.fatec.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Cart already finished")
public class AlreadyFinishedCart extends RuntimeException {

	private static final long serialVersionUID = -439437257773998778L;

	public AlreadyFinishedCart(String message) {
		super(message);
	}
	
	public AlreadyFinishedCart(Throwable reason) {
		super(reason);
	}
	
	public AlreadyFinishedCart(String message, Throwable reason) {
		super(message, reason);
	}
}
