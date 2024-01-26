package com.fga.consultorio.controllers;

import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;
import com.fga.consultorio.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/consulting/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    //Create new doctor
    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping()
    public String listDoctors(Model model){
        List<DoctorDto> doctors = doctorService.findAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctors-list";
    }
}
