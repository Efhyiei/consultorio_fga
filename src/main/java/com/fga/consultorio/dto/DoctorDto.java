package com.fga.consultorio.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DoctorDto {

    private Long id;
    private String firstName;
    private String fatherLastName;
    private String motherLastName;
    private String fullName;
    private LocalDateTime createdDate;
    private LocalDateTime lastUpdateDate;
}
