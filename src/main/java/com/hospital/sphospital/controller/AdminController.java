package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.service.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;




@Controller
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class AdminController {

    private final  AddDoctorService addDoctorService;
    private final AdminPageService adminPageService;
    private final DeleteDoctorService deleteDoctorService;
    private final UpdateDoctorService updateDoctorService;
    private final DoctorByIdService doctorByIdService;


    private final PatientListByDoctorForAdminService patientListByDoctorForAdminService;


    @PostMapping("/addnewdoctor")
    private String addNewDoctor(@Valid @ModelAttribute("doctors") Doctor doctor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        addDoctorService.addNewDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/addnewdoctor")
    private String addNewDoctorGet(@Valid @ModelAttribute("doctors") Doctor doctor, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        addDoctorService.addNewDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/test")

    private String test() {

        return "testTemplate";
    }




    @GetMapping()
    private String getAllDoctors(Model model, @PageableDefault(size = 5)  Pageable pageable) throws CommandException {



        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);

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


    @GetMapping("/patientsByDoctorID")
    public String findPatientsByDoctorId(@Valid @ModelAttribute("doctors") Doctor doctor, BindingResult bindingResult,
                                          @PageableDefault(size = 5)  Pageable pageable,
                                          Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }

        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);
        }

        var doctorById = doctorByIdService.findByDoctorId(doctor);
        model.addAttribute("doctorById", doctorById);
        model.addAttribute("patientsByDoctorId",  patientListByDoctorForAdminService.findByDoctorId(doctor, pageable));
        return "patientlistbydoctoradmin";
    }


//    @GetMapping("/session")
//
//    public String printActiveUser() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) principal;
//            System.out.println("Active User: " + userDetails.getUsername());
//            System.out.println("Authorities: " + userDetails.getAuthorities());
//            System.out.println(userDetails.isAccountNonLocked());
//            System.out.println(userDetails.isEnabled());
//            System.out.println(((UserDetails) principal).getAuthorities());
//        } else {
//            System.out.println("No active user");
//        }
//        return "testTemplate";
//    }
//
//    @GetMapping("/sessions")
//    public String printActiveUsers() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            UserDetails userDetails = (UserDetails) principal;
//            System.out.println("Active User: " + userDetails.getUsername());
//            System.out.println("Authorities: " + userDetails.getAuthorities());
//            System.out.println(((UserDetails) principal).getAuthorities());
//        } else {
//            System.out.println("No active user");
//        }
//        return "testTemplate";
//    }

}
