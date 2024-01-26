package com.fga.consultorio.services;

import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);
    List<DoctorDto> findAllDoctors();
}
