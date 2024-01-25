package com.fga.consultorio.services;

import com.fga.consultorio.domain.Patient;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    Patient createPatient(Patient patient);
}
