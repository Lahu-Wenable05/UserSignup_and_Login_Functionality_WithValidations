package com.wenable.UserAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wenable.UserAuth.Dao.IUserDao;
import com.wenable.UserAuth.UserValidation.EmailValidation;
import com.wenable.UserAuth.UserValidation.PasswordValidation;
import com.wenable.UserAuth.customException.EmailAlreadyExistException;
import com.wenable.UserAuth.customException.InvalidEmailException;
import com.wenable.UserAuth.customException.InvalidPasswordException;
import com.wenable.UserAuth.customException.UserAlreadyExistException;
import com.wenable.UserAuth.dto.LoginDto;
import com.wenable.UserAuth.dto.LoginResponseDto;
import com.wenable.UserAuth.dto.UserResponseDto;
import com.wenable.UserAuth.entity.User;
import com.wenable.UserAuth.genericResponse.GenericResponse;

@Service
public class UserService {

	@Autowired
	private EmailValidation emailValidation;

	@Autowired
	private PasswordValidation passwordValidation;

	@Autowired
	private IUserDao userDao;

	private User user = null;

	public User registerUser(UserResponseDto userResponseDto) {
//		try {
		emailValidation.isValidEmail(userResponseDto.getEmail());
		userDao.existsByUserName(userResponseDto.getUserName());
		userDao.existsByEmail(userResponseDto.getEmail());
		passwordValidation.isValidPassword(userResponseDto.getPassword());

		/*****************
		 * } catch (InvalidEmailException | UserAlreadyExistException |
		 * InvalidPasswordException | EmailAlreadyExistException ue) {
		 * 
		 * System.err.println("Invalid e-mail.. It must be in valid format..");
		 * System.err.println(ue.getMessage()); throw ue; return null; } catch
		 * (UserAlreadyExistException userEx) { System.err.println("User already
		 * exist.."); System.err.println(userEx.getMessage()); } catch
		 * (InvalidPasswordException ip) { System.err.println("Invalid password enter
		 * valid 8 character password.."); System.err.println(ip.getMessage()); }catch
		 * (EmailAlreadyExistException eae) { System.err.println("Invalid password enter
		 * valid 8 character password.."); System.err.println(eae.getMessage()); }
		 ************************/

		user = new User();
		user.setUserName(userResponseDto.getUserName());
		user.setEmail(userResponseDto.getEmail());
		user.setPassword(userResponseDto.getPassword());
		user.setFirstName(userResponseDto.getFirstName());
		user.setLastName(userResponseDto.getLastName());
		user.setPhoneNumber(userResponseDto.getPhoneNumber());

		return userDao.save(user);
	}

	public GenericResponse loginUser(LoginDto loginDto) {
		User foundUser = userDao.findByUserName(loginDto.getUserName());
		if ((foundUser == null) || (!foundUser.getPassword().equals(loginDto.getPassword()))) {
			return new GenericResponse(false, "Invalid email or password", null);
		}
		LoginResponseDto loginResponseDto = new LoginResponseDto(foundUser.getId(), foundUser.getUserName(),
				foundUser.getEmail());
		return new GenericResponse(true, "Login successful", loginResponseDto);
	}
}
