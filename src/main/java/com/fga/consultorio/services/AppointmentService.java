package com.fga.consultorio.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public interface AppointmentService {
    public void createAppointment(Long doctorId, Date appointmentDate, String patientEmail, String patientName, String appointmentHour);
}
