package com.fga.consultorio.services;

import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;
import com.fga.consultorio.dto.response.GetAllDoctorsResponse;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);
    GetAllDoctorsResponse findAllDoctors();
}
