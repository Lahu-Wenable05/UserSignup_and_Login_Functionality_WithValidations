package com.wenable.UserAuth.UserValidation;

import com.wenable.UserAuth.customException.UserException;

public class UserNameValidation {

	@SuppressWarnings("null")
	public boolean isValidUserName(String userName) throws UserException {
		if ((userName == null) && (userName.isBlank())) {
			throw new UserException("");
		}
		boolean validUsername = userName.matches("^[a-z0-9+_.-]+@[a-z0-9.-]+$");

		if (!validUsername) {
			throw new UserException("Enter valid User-Name..");
		} else {
			return true;
		}
	}

}
