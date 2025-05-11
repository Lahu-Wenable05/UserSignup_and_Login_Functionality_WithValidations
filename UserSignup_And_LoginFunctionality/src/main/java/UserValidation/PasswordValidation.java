package com.wenable.UserAuth.UserValidation;

import org.springframework.stereotype.Component;

import com.wenable.UserAuth.customException.UserException;

@Component
public class PasswordValidation {

//	@SuppressWarnings("null")
	public boolean isValidPassword(String password) throws UserException {

		if ((password == null) && (!(password.length()<=8))) {
			throw new UserException("Password must not be null..");
		}
		return true;
	}
}
