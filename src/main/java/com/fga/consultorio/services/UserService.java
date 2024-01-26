package com.fga.consultorio.services;

import com.fga.consultorio.domain.User;
import com.fga.consultorio.dto.request.UserLoginRequest;
import com.fga.consultorio.dto.request.UserRegistrationRequest;
import com.fga.consultorio.dto.response.AuthResponse;


public interface UserService {

    AuthResponse login(UserLoginRequest request);
    AuthResponse save(UserRegistrationRequest request);
}
