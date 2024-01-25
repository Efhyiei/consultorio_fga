package com.fga.consultorio.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DoctorScheduleDto {
    private Long id;
    private Long doctorId;
    private String appointmentDate;
    private String appointmentHour;
    private boolean available;
}
