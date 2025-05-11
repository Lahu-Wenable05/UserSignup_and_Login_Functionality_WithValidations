package com.wenable.UserAuth.genericResponse;

import com.wenable.UserAuth.dto.LoginResponseDto;

public class GenericResponse {

	private boolean success;
	private String message;
//	private UserDto userDto;
	private Object object;

	public GenericResponse(boolean success, String message,Object object) {
		this.success = success;
		this.message = message;
//		this.userDto = userDto;
		this.object = object;
	}

	public boolean isSuccess() {
		return success;
	} 

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public UserDto getData() {
//		return userDto;
//	}
//
//	public void setData(UserDto userDto) {
//		this.userDto = userDto;
//	}
	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
