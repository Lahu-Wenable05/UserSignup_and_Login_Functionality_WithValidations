package com.wenable.UserAuth.UserValidation;

import org.springframework.stereotype.Component;

import com.wenable.UserAuth.customException.UserException;

@Component
public class EmailValidation {

	public boolean isValidEmail(String email) throws UserException {
		String regex="^[a-z0-9+_.-]+@[a-z0-9.-]+$";
		return email!=null && email.matches(regex); 
		
	}

//public boolean isExistUserName(User user, Integer id) { if
//    (userRepo.existsById(id)) { return false; } return true; }
}
