package com.wenable.UserAuth.UserValidation;

import org.springframework.stereotype.Component;

import com.wenable.UserAuth.customException.InvalidPasswordException;

@Component
public class PasswordValidation {

//	@SuppressWarnings("null")
	public boolean isValidPassword(String password) throws InvalidPasswordException {
		if (password == null || password.length() < 8) {
			throw new InvalidPasswordException("Invalid password: must be at least 8 alphanumeric characters.");
		}
		return true;
	}
}
