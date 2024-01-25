package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.DoctorScheduleRepository;
import com.fga.consultorio.services.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {

    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;


    @Override
    public List<String> getSchedulesByDay(Integer doctorId, Date date) {

        return doctorScheduleRepository.getAvailableAppointments(doctorId, date);
    }
}
