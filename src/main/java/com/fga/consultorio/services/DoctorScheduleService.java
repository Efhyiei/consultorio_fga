package com.fga.consultorio.services;

import com.fga.consultorio.dto.DoctorScheduleDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface DoctorScheduleService {

    List<String> getSchedulesByDay(Integer doctorId, Date date);
}
