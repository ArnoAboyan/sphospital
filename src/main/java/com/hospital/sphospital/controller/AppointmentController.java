package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.service.AddAppointmentService;
import com.hospital.sphospital.service.AppointmentListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    AddAppointmentService addappointmentService;

    @Autowired
    AppointmentListService appointmentListService;








    @PostMapping("/newappointment/{pagenumber}")
    public String addAppointment(@Valid @ModelAttribute("appointments") Appointment appointment,
                                 @PathVariable("pagenumber") int pageNumber,
                                 BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }

        addappointmentService.addNewAppointment(appointment);
//        appointmentRepository.save(appointment);
        return "redirect:/patients?page=" + (pageNumber);
    }


    @GetMapping
    private String getAllAppointments (Model model, @PageableDefault(size = 5) Pageable pageable){

        System.out.println(pageable);


        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);
            System.out.println(sortName);
        }

        try {
            model.addAttribute("appointments", appointmentListService.getAllAppointments(pageable));
        } catch (CommandException e) {
            throw new RuntimeException(e.getMessage());
        }

        return "appointmentlist";
    }


}
