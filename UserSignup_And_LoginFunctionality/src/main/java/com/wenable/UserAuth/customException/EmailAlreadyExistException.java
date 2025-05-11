package com.wenable.UserAuth.customException;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String msg) {
		super(msg);
	}
	

}
