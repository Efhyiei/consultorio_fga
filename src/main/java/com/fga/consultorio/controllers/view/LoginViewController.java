package com.fga.consultorio.controllers.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/consulting/users/auth/")
@Slf4j
public class LoginViewController {

    @GetMapping("login")
    public String showLoginForm(Model model)
    {
        return "login";
    }
}
