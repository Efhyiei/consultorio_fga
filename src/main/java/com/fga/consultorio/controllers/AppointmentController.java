package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.CreateAppointmentRequest;
import com.fga.consultorio.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulting/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<String> createAppointment(@RequestBody CreateAppointmentRequest request) {
        try {
            appointmentService.createAppointment(
                    request.getPatientId(),
                    request.getDoctorId(),
                    request.getAppointmentDate(),
                    request.getPatientEmail(),
                    request.getAppointmentHour()
            );
            return ResponseEntity.ok("Appointment created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment: " + e.getMessage());
        }
    }
}
