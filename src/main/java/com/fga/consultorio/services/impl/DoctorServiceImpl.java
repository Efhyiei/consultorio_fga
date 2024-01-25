package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.DoctorRepository;
import com.fga.consultorio.domain.Doctor;
import com.fga.consultorio.dto.DoctorDto;
import com.fga.consultorio.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<DoctorDto> findAllDoctors() {
        List<Doctor> doctors= doctorRepository.findAll();
        return doctors.stream().map(this::mapToDoctorDto).collect(Collectors.toList());
    }

    private DoctorDto mapToDoctorDto(Doctor doctor)
    {
        return DoctorDto.builder()
                .id(doctor.getId())
                .fullName(doctor.getFullName())
                .build();
    }
}
