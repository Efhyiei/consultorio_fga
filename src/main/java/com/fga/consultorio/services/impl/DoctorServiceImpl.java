package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.DoctorRepository;
import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;
import com.fga.consultorio.dto.response.GetAllDoctorsResponse;
import com.fga.consultorio.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public GetAllDoctorsResponse findAllDoctors() {
        List<Doctor> doctors= doctorRepository.findAll();
        return GetAllDoctorsResponse.builder()
                .doctors(doctors.stream().map(this::mapToDoctorDto).collect(Collectors.toList()))
                .build();
    }

    private DoctorDto mapToDoctorDto(Doctor doctor)
    {
        return DoctorDto.builder()
                .id(doctor.getId())
                .fullName(doctor.getFullName())
                .build();
    }
}
