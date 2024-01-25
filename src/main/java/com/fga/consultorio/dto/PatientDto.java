package com.fga.consultorio.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class PatientDto {
    private Long patientId;
    private String fullName;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdateDate;
}
