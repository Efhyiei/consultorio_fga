package com.fga.consultorio.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fga.consultorio.util.CustomDateDeserializer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Getter
@Setter
public class CreateAppointmentRequest {
    private Long doctorId;
    private Date appointmentDate;
    private String patientEmail;
    private String patientName;
    private String appointmentHour;
}
