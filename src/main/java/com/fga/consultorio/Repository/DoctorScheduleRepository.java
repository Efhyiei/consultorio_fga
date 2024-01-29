package com.fga.consultorio.Repository;

import com.fga.consultorio.domain.DoctorSchedule;
import com.fga.consultorio.dto.response.GetDoctorDayAppointmentsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

    @Query(value = "SELECT * FROM get_available_appointments(?1, ?2)", nativeQuery = true)
    List<String> getAvailableAppointments(@Param("p_doctor_id") Integer doctor_id, @Param("p_day") String p_day);

    @Query(value = "SELECT * FROM doctor_schedule WHERE doctor_id = :p_doctor_id AND appointment_date = :p_appointment_date AND appointment_hour = :p_appointment_hour AND available = true", nativeQuery = true)
    DoctorSchedule findAppointmentInSchedule(@Param("p_doctor_id") Integer doctorId, @Param("p_appointment_date") String date, @Param("p_appointment_hour") String appointmentHour);

}
