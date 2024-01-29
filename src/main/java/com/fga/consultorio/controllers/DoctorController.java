package com.fga.consultorio.controllers;

import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;
import com.fga.consultorio.dto.response.GetAllDoctorsResponse;
import com.fga.consultorio.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/consulting/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    //Create new doctor
    @PostMapping("/create")
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/findAll")
    public ResponseEntity<GetAllDoctorsResponse> getAllDoctors(Model model){
        GetAllDoctorsResponse response = doctorService.findAllDoctors();
        return ResponseEntity.ok(response);
    }
}
