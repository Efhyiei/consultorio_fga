package com.fga.consultorio.services;

import com.fga.consultorio.dto.DoctorScheduleDto;
import com.fga.consultorio.dto.response.GetDoctorAppointmentsResponse;
import com.fga.consultorio.dto.response.GetDoctorDayAppointmentsResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface DoctorScheduleService {

    GetDoctorAppointmentsResponse getSchedulesByDay(Integer doctorId, Date date);

    List<GetDoctorDayAppointmentsResponse> getDoctorDayAppointment(Integer doctorId, Date date);
}
