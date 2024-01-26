package com.fga.consultorio.controllers;

import com.fga.consultorio.domain.Patient;
import com.fga.consultorio.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/consulting/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient)
    {
        try{
            patientService.createPatient(patient);
            return ResponseEntity.ok("Patient created successfully.");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create patient: " + e.getMessage());
        }
    }
}
