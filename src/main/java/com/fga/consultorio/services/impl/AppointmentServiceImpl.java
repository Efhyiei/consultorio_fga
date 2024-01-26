package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.AppointmentRepository;
import com.fga.consultorio.Repository.DoctorScheduleRepository;
import com.fga.consultorio.domain.Appointment;
import com.fga.consultorio.domain.DoctorSchedule;
import com.fga.consultorio.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    public void createAppointment(Long patientId, Long doctorId, LocalDateTime appointmentDate, String patientEmail, String appointmentHour) {
        // Convert LocalDateTime to Date
        Date date = Date.from(appointmentDate.atZone(ZoneId.systemDefault()).toInstant());

        // Check if the selected hour is available
        List<String> availableHours = doctorScheduleRepository.getAvailableAppointments(doctorId.intValue(), date);
        if (!availableHours.contains(appointmentHour)) {
            throw new RuntimeException("Selected hour is not available.");
        }

        // Create and save the appointment
        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setPatientEmail(patientEmail);
        appointment.setAppointmentHour(appointmentHour);

        appointmentRepository.save(appointment);

        // Update DoctorSchedule to mark the selected hour as not available
        DoctorSchedule doctorSchedule = doctorScheduleRepository.findByDoctorIdAndAppointmentDateAndAppointmentHour(
                doctorId, date.toString(), appointmentHour);

        if (doctorSchedule != null) {
            doctorSchedule.setAvailable(false);
            doctorScheduleRepository.save(doctorSchedule);
        } else {
            throw new RuntimeException("DoctorSchedule not found for the specified date and hour.");
        }
    }
}
