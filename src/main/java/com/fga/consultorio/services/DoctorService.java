package com.fga.consultorio.services;

import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);
    List<DoctorDto> findAllDoctors();
}
