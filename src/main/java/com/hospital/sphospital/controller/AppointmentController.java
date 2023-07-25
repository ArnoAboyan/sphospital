package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import com.hospital.sphospital.service.AddAppointmentService;
import com.hospital.sphospital.service.AppointmentListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
@Log
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    private final AddAppointmentService addappointmentService;

    private final AppointmentListService appointmentListService;

    private final HospitalCardRepository hospitalCardRepository;


    @GetMapping("/newappointment/{pagenumber}")
    public String addAppointment(@Valid @ModelAttribute("appointments") Appointment appointment,
                                 @PathVariable("pagenumber") int pageNumber,
                                 BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }

        addappointmentService.addNewAppointment(appointment);

        return "redirect:/patients?page=" + (pageNumber);
    }


    @GetMapping
    private String getAllAppointments(Model model, @PageableDefault(size = 5) Pageable pageable) {

;


        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);
        }

        try {
            model.addAttribute("appointments", appointmentListService.getAllAppointments(pageable));
        } catch (CommandException e) {
            throw new RuntimeException(e.getMessage());
        }

        return "appointmentlist";
    }
//@GetMapping("/deleteAll")
//    public String deleteAll(){
//        appointmentRepository.deleteAll();
//        return "redirect:/doctors";
//    }

}
