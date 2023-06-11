package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class AdminController {
    @Autowired
    private AddDoctorService addDoctorService;
    @Autowired
    private AdminPageService adminPageService;
    @Autowired
    private DeleteDoctorService deleteDoctorService;
    @Autowired
    private UpdateDoctorService updateDoctorService;

    @Autowired
    PatientListByDoctorForAdminService patientListByDoctorForAdminService;


    @PostMapping("/addnewdoctor")
    private String addNewDoctor(@Valid @ModelAttribute("doctors") Doctor doctor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        addDoctorService.addNewDoctor(doctor);
        return "redirect:/doctors";
    }


    @GetMapping()
    private String getAllDoctors(Model model, @PageableDefault(size = 5)  Pageable pageable) throws CommandException {

        System.out.println(pageable);

        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);
            System.out.println(sortName);
        }

        model.addAttribute("doctors", adminPageService.getAllDoctors(pageable));
        return "admin";
    }

    @GetMapping("/deletedoctor")
    private String deleteDoctor(@RequestParam("doctorId") int doctorId) {
        deleteDoctorService.deleteDoctorById(doctorId);
        return "redirect:/doctors";
    }


    @PostMapping("/edit/{pagenumber}")
    private String updateDoctor(@Valid @ModelAttribute("doctors") Doctor doctor,
                          BindingResult bindingResult,
                          Model model,
                          @PathVariable("pagenumber") int pageNumber) throws CommandException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        updateDoctorService.updateDoctor(doctor);
        return "redirect:/doctors?page=" + (pageNumber);
    }

//    @GetMapping("/patientsByDoctorID")
//    private String findPatientsByDoctorId(@RequestParam("doctorId") int doctorId,
//                                          @PageableDefault(size = 5)  Pageable pageable,
//                                          Model model){
//
//        model.addAttribute("appointmentsByDoctorId",  patientListByDoctorForAdminService.findByDoctorId(doctorId, pageable));
//
//        return "patientlistbydoctoradmin";
//    }



    @GetMapping("/patientsByDoctorID")
    private String findPatientsByDoctorId(@Valid @ModelAttribute("doctors") Doctor doctor, BindingResult bindingResult,
                                          @PageableDefault(size = 5)  Pageable pageable,
                                          Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        model.addAttribute("appointmentsByDoctorId",  patientListByDoctorForAdminService.findByDoctorId(doctor, pageable));

        return "patientlistbydoctoradmin";
    }

}
