package com.fga.consultorio.services.impl;

import com.fga.consultorio.Repository.PatientRepository;
import com.fga.consultorio.domain.Patient;
import com.fga.consultorio.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
