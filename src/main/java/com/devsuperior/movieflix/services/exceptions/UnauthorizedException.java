package com.devsuperior.movieflix.services.exceptions;

public class UnauthorizedException  extends RuntimeException{

	private static final long serialVersionUID = 5573572785382419086L;
	
	public UnauthorizedException(String msg) {
		super(msg);
	}

}
