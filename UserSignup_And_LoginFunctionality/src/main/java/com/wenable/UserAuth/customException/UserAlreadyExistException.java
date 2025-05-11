package com.wenable.UserAuth.customException;

public class UserAlreadyExistException extends RuntimeException {

	public UserAlreadyExistException(String msg) {
		super(msg);
	}

}
