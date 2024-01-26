package com.fga.consultorio.controllers;

import com.fga.consultorio.dto.request.GetDoctorAppointmentsRequest;
import com.fga.consultorio.services.DoctorScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consulting/doctors/schedule")
@Slf4j
public class DoctorScheduleController {

    @Autowired
    private DoctorScheduleService doctorScheduleService;

    //Get available appointments by day
    @GetMapping("/getAvailableAppointments")
    public List<String> getAvailableAppointments(@RequestBody GetDoctorAppointmentsRequest request)
    {
        log.info("doctorId: " + request.getDoctorId());
        log.info("date: " + request.getDate());
        return doctorScheduleService.getSchedulesByDay(request.getDoctorId(), request.getDate());
    }
}
