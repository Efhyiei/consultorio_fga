package com.fga.consultorio.controllers.view;

import com.fga.consultorio.dto.request.GetDoctorDayAppointmentsRequest;
import com.fga.consultorio.dto.response.GetDoctorDayAppointmentsResponse;
import com.fga.consultorio.services.DoctorScheduleService;
import com.fga.consultorio.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/consulting/view/schedules")
@RequiredArgsConstructor
public class DoctorScheduleViewController {

    private final DoctorService doctorService;
    private final DoctorScheduleService doctorScheduleService;

    @GetMapping("/report")
    public String showReportPage(Model model) {
        // Populate the model with necessary data (e.g., list of doctors)
        model.addAttribute("doctors", doctorService.findAllDoctors());
        model.addAttribute("reportRequest", new GetDoctorDayAppointmentsRequest()); // Create an instance of your form backing bean
        return "scheduleReport";
    }

    @PostMapping("/report")
    public String generateReport(@ModelAttribute GetDoctorDayAppointmentsRequest reportRequest, Model model) {
        // Fetch report data based on the selected doctor and date
        List<GetDoctorDayAppointmentsResponse> reportData = doctorScheduleService.getDoctorDayAppointment(
                reportRequest.getDoctorId(),
                reportRequest.getDate()
        );

        // Populate the model with the report data
        model.addAttribute("reportData", reportData);
        model.addAttribute("doctors", doctorService.findAllDoctors()); // Include the list of doctors for the form

        return "report";
    }
}
