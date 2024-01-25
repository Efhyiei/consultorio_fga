package com.fga.consultorio.Repository;

import com.fga.consultorio.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
