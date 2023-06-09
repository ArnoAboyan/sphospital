package com.hospital.sphospital.controller;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.PatientRepository;
import com.hospital.sphospital.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    AddPatientService addPatientService;

    @Autowired
    PatientListService patientListService;

    @Autowired
    AdminPageService adminPageService;

    @Autowired
    DeletePatientService deletePatientService;
    @Autowired
    UpdatePatientService updatePatientService;


    @PostMapping("/addnewpatient")
    private String addNewPatient(@Valid @ModelAttribute("patients") Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingResult", bindingResult);
            return "error";
        }
        addPatientService.addNewPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/deletepatient")
    private String deletePatient(@RequestParam("patientId") int doctorId, @RequestParam("pagenumber") Integer pagenumber) {
        deletePatientService.patientDelete(doctorId);
        System.out.println(pagenumber);
        return "redirect:/patients?page=" + (pagenumber);
    }




        private List<Doctor> appointmentDoctors() throws CommandException {
       return adminPageService.getAllDoctorsForAppointments();
    }

    @GetMapping
    private String getAllPatients(Model model, @PageableDefault(size = 5) Pageable pageable) throws CommandException {
        System.out.println(pageable);


        Sort sort = pageable.getSort();

        List<Sort.Order> orders = sort.toList();
        for (Sort.Order order : orders) {
            String sortName = order.getProperty();
            model.addAttribute("sortName", sortName);
            System.out.println(sortName);
        }

        model.addAttribute("patients", patientListService.getAllPatients(pageable));
        model.addAttribute("doctors", appointmentDoctors());
        return "patientlist";
    }

@PostMapping("/edit/{pagenumber}")
    private String updatePatient (@Valid @ModelAttribute("patients") Patient patient,
                                  BindingResult bindingResult,
                                  Model model,
                                  @PathVariable("pagenumber") int pageNumber) throws CommandException {

    if (bindingResult.hasErrors()) {
        model.addAttribute("bindingResult", bindingResult);
        return "error";
    }
    updatePatientService.updatePatient(patient);
    return "redirect:/patients?page=" + (pageNumber);

   }



}