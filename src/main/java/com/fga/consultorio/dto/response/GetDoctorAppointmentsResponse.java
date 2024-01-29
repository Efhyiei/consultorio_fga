package com.fga.consultorio.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetDoctorAppointmentsResponse {
    List<String> appointments;
}
