package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.CreateAppointmentRequest;
import com.fga.consultorio.dto.request.GetDoctorDayAppointmentsRequest;
import com.fga.consultorio.dto.response.GetDoctorDayAppointmentsResponse;
import com.fga.consultorio.services.AppointmentService;
import com.fga.consultorio.services.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/consulting/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final DoctorScheduleService doctorScheduleService;


    @PostMapping("/create")
    public ResponseEntity<String> createAppointment(@RequestBody CreateAppointmentRequest request) {
        try {
            appointmentService.createAppointment(
                    request.getDoctorId(),
                    request.getAppointmentDate(),
                    request.getPatientEmail(),
                    request.getPatientName(),
                    request.getAppointmentHour()
            );
            return ResponseEntity.ok("Appointment created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create appointment: " + e.getMessage());
        }
    }

    @PostMapping("/getDoctorDaySchedule")
    public ResponseEntity<List<GetDoctorDayAppointmentsResponse>> getDoctorDayAppoinments(@RequestBody GetDoctorDayAppointmentsRequest request)
    {
        try{
            return ResponseEntity.ok(doctorScheduleService.getDoctorDayAppointment(request.getDoctorId(), request.getDate()));
        }catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
