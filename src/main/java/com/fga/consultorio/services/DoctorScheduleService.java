package com.fga.consultorio.services;

import java.util.Date;
import java.util.List;

public interface DoctorScheduleService {

    List<String> getSchedulesByDay(Integer doctorId, Date date);
}
