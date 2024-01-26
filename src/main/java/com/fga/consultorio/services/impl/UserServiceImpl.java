package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.UserRepository;
import com.fga.consultorio.domain.Role;
import com.fga.consultorio.domain.User;
import com.fga.consultorio.dto.request.UserRegistrationRequest;
import com.fga.consultorio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserRegistrationRequest request) {

        Role userRole = Role.builder()
                .roleName("ROLE_USER")
                .build();

        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(Collections.singletonList(userRole))
                .build();

        return userRepository.save(user);
    }
}
