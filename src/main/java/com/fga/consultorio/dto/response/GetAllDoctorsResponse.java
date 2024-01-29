package com.fga.consultorio.dto.response;

import com.fga.consultorio.dto.DoctorDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDoctorsResponse {
    List<DoctorDto> doctors;
}
