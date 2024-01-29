package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.AppointmentRepository;
import com.fga.consultorio.Repository.DoctorScheduleRepository;
import com.fga.consultorio.domain.Appointment;
import com.fga.consultorio.dto.response.GetAllDoctorsResponse;
import com.fga.consultorio.dto.response.GetDoctorAppointmentsResponse;
import com.fga.consultorio.dto.response.GetDoctorDayAppointmentsResponse;
import com.fga.consultorio.services.DoctorScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    private final DoctorScheduleRepository doctorScheduleRepository;
    private final AppointmentRepository appointmentRepository;

    @Override
    public GetDoctorAppointmentsResponse getSchedulesByDay(Integer doctorId, Date date) {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = dateFormat.format(date);

        List<String> appointments = doctorScheduleRepository.getAvailableAppointments(doctorId, sDate);

        return GetDoctorAppointmentsResponse.builder()
                .appointments(appointments)
                .build();
    }

    @Override
    public List<GetDoctorDayAppointmentsResponse> getDoctorDayAppointment(Integer doctorId, Date date) {

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = dateFormat.format(date);

        log.info("DoctorId: " + doctorId);
        log.info("Date: " + sDate);

        List<Appointment> dayAppointments = appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, sDate);

        return dayAppointments.stream()
                .map(appointment -> new GetDoctorDayAppointmentsResponse(appointment.getPatientName(), appointment.getPatientEmail(), appointment.getAppointmentDate(), appointment.getAppointmentHour()))
                .toList();
    }
}
