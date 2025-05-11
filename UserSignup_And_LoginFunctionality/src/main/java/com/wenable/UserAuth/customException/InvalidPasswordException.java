package com.wenable.UserAuth.customException;

public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException(String msg) {
		super(msg);
	}

	
}
