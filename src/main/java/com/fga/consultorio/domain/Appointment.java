package com.fga.consultorio.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fga.consultorio.util.CustomDateDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "appointment_id")
    private Long id;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "patient_email")
    private String patientEmail;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "appointment_hour")
    private String appointmentHour;
}
