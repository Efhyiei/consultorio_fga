package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.AppointmentRepository;
import com.fga.consultorio.Repository.DoctorScheduleRepository;
import com.fga.consultorio.domain.Appointment;
import com.fga.consultorio.domain.DoctorSchedule;
import com.fga.consultorio.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorScheduleRepository doctorScheduleRepository;

    // Other dependencies and methods...

    public void createAppointment(Long doctorId, Date appointmentDate, String patientEmail, String patientName, String appointmentHour) {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(appointmentDate);

        log.info("doctorId: " + doctorId.intValue());
        log.info("date: " + date);
        log.info("appointmentHour: " + appointmentHour);
        // Check in doctor schedule for the selected date and hour
        DoctorSchedule doctorSchedule = doctorScheduleRepository.findAppointmentInSchedule(
                doctorId.intValue(), date, appointmentHour);

        if (doctorSchedule != null) {
            doctorSchedule.setAvailable(false);
        } else {
            throw new RuntimeException("DoctorSchedule not found for the specified date and hour.");
        }

        appointmentRepository.save(Appointment.builder()
                        .doctorId(doctorId)
                        .appointmentDate(date)
                        .patientName(patientName)
                        .patientEmail(patientEmail)
                        .appointmentHour(appointmentHour)
                        .build());
        doctorScheduleRepository.save(doctorSchedule);
    }
}
