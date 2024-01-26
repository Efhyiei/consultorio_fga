package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.UserLoginRequest;
import com.fga.consultorio.dto.request.UserRegistrationRequest;
import com.fga.consultorio.dto.response.AuthResponse;
import com.fga.consultorio.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consulting/users/auth/")
@Slf4j
public class UserRegistrationController {

    private final UserService userService;

    @Autowired
    public UserRegistrationController(UserService userService)
    {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationRequest userRegistrationRequest(){
        return new UserRegistrationRequest();
    }

    @GetMapping("login")
    public String showLoginForm(Model model)
    {
        model.addAttribute("user", new UserLoginRequest());
        return "login";
    }


    @PostMapping("register")
    public ResponseEntity<AuthResponse> registerUserAccount(@RequestBody UserRegistrationRequest request)
    {
        return ResponseEntity.ok(userService.save(request));
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserLoginRequest request)
    {
        return ResponseEntity.ok(userService.login(request));
    }
}
