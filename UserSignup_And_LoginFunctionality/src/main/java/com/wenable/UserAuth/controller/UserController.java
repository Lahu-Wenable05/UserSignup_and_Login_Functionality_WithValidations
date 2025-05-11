package com.wenable.UserAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenable.UserAuth.customException.UserException;
import com.wenable.UserAuth.dto.LoginDto;
import com.wenable.UserAuth.dto.UserResponseDto;
import com.wenable.UserAuth.entity.User;
import com.wenable.UserAuth.genericResponse.GenericResponse;
import com.wenable.UserAuth.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<User> userSignup(@RequestBody UserResponseDto userResponseDto) {
		User response = userService.registerUser(userResponseDto);
		return ResponseEntity.ok(response); 
	}

	@PostMapping("/login")
	public ResponseEntity<GenericResponse> userLogin(@RequestBody LoginDto loginRequest) {
		GenericResponse response = userService.loginUser(loginRequest);
		return new ResponseEntity<GenericResponse>(response,
				response.isSuccess() ? HttpStatus.OK : HttpStatus.UNAUTHORIZED);
	}

}
