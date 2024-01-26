package com.fga.consultorio.services;

import com.fga.consultorio.domain.User;
import com.fga.consultorio.dto.request.UserRegistrationRequest;


public interface UserService {
    User save(UserRegistrationRequest request);
}
