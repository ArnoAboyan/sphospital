package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.service.AddAppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AddAppointmentService appointmentService;







    @PostMapping("/newappointment/{pagenumber}")
    public String addAppointment(@Valid @ModelAttribute("appointments") Appointment appointment,
                                 @PathVariable("pagenumber") int pageNumber,
                                 BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        appointmentRepository.save(appointment);
        return "redirect:/patients?page=" + (pageNumber);
    }


//    @PostMapping("/newappointment")
//    public String addAppointment(@Valid @ModelAttribute("appointments") Appointment appointment)
//    {
//        System.out.println(appointment.getAppointmentId());
//        appointmentRepository.save(appointment);
//        return "redirect:/patients";
//    }
}
