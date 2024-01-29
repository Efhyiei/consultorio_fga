package com.fga.consultorio.Repository;

import com.fga.consultorio.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT * FROM appointment WHERE doctor_id = :p_doctor_id AND appointment_date = :p_appointment_date", nativeQuery = true)
    List<Appointment> findByDoctorIdAndAppointmentDate(@Param("p_doctor_id") Integer doctorId, @Param("p_appointment_date") String appointmentDay);
}
