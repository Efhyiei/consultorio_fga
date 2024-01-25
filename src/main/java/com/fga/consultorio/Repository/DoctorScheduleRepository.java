package com.fga.consultorio.Repository;

import com.fga.consultorio.domain.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

    @Query(value = "SELECT * FROM get_available_appointments(:p_doctor_id, :p_day)", nativeQuery = true)
    List<String> getAvailableAppointments(@Param("p_doctor_id") Integer doctor_id, @Param("p_day") Date p_day);
}
