package com.wenable.UserAuth.UserValidation;

import org.springframework.stereotype.Component;

import com.wenable.UserAuth.customException.InvalidEmailException;
import com.wenable.UserAuth.customException.UserException;

@Component
public class EmailValidation {

	public boolean isValidEmail(String email) throws InvalidEmailException {
		String regex = "^[a-z0-9+_.-]+@[a-z0-9.-]+$";
		if ((email == null) || (!email.matches(regex))) {
			throw new InvalidEmailException("Invalid e-mail.. It must be in valid format..");
		} else {
			return true; 
 
		}

	}

//public boolean isExistUserName(User user, Integer id) { if
//    (userRepo.existsById(id)) { return false; } return true; }
}
