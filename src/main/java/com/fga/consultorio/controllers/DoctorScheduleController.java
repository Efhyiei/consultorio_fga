package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.GetDoctorAppointmentsRequest;
import com.fga.consultorio.dto.response.GetDoctorAppointmentsResponse;
import com.fga.consultorio.services.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/consulting/doctors/schedule")
@RequiredArgsConstructor
@Slf4j
public class DoctorScheduleController {

    private final DoctorScheduleService doctorScheduleService;

    //Get available appointments by day
    @PostMapping("/getAvailableAppointments")
    public ResponseEntity<GetDoctorAppointmentsResponse> getAvailableAppointments(@RequestBody GetDoctorAppointmentsRequest request)
    {
        return ResponseEntity.ok(doctorScheduleService.getSchedulesByDay(request.getDoctorId(), request.getDate()));
    }
}
