package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.UserRegistrationRequest;
import com.fga.consultorio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consulting/users/registration")
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

    @GetMapping
    public String showRegistrationForm(Model model)
    {
        model.addAttribute("user", new UserRegistrationRequest());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user")UserRegistrationRequest request)
    {
        userService.save(request);
        return "redirect:/consulting/users/registration?success";
    }
}
