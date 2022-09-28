package com.devsuperior.movieflix.services.exceptions;

public class ForbiddenException  extends RuntimeException{

	private static final long serialVersionUID = 5573572785382419086L;
	
	public ForbiddenException(String msg) {
		super(msg);
	}

}
