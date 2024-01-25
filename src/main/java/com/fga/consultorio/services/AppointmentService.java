package com.fga.consultorio.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface AppointmentService {
    public void createAppointment(Long patientId, Long doctorId, LocalDateTime appointmentDate, String patientEmail, String appointmentHour);
}
