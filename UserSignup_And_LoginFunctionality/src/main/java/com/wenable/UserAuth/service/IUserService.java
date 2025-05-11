package com.wenable.UserAuth.service;

import com.wenable.UserAuth.dto.LoginDto;
import com.wenable.UserAuth.entity.User;
import com.wenable.UserAuth.genericResponse.GenericResponse;

public interface IUserService {

    public GenericResponse registerUser(User user);
    public GenericResponse loginUser(LoginDto loginRequest);
}
