package com.fga.consultorio.services;


import java.time.LocalDateTime;


public interface AppointmentService {
    public void createAppointment(Long patientId, Long doctorId, LocalDateTime appointmentDate, String patientEmail, String appointmentHour);
}
