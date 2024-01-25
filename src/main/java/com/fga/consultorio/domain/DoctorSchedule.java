package com.fga.consultorio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "doctor_schedule")
public class DoctorSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "schedule_id")
    private Long id;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "appointment_hour")
    private String appointmentHour;
    @Column(name = "available")
    private boolean available;
}
