package com.fga.consultorio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorDayAppointmentsResponse {
    String patientName;
    String patientEmail;
    String appointmentDate;
    String appointmentHour;
}
