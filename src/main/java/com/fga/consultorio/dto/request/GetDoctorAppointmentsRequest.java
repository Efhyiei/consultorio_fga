package com.fga.consultorio.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class GetDoctorAppointmentsRequest {
    Integer doctorId;
    Date date;
}
