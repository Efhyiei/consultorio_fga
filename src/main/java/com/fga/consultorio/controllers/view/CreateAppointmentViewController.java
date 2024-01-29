package com.fga.consultorio.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/consulting/view/appointment")
public class CreateAppointmentViewController {

    @GetMapping("/create")
    public String createAppointmentView(Model model)
    {
        return "createAppointment";
    }
}
