package com.hospital.sphospital.controller;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.PatientRepository;
import com.hospital.sphospital.service.AddPatientService;
import com.hospital.sphospital.service.DeletePatientService;
import com.hospital.sphospital.service.PatientListService;
import com.hospital.sphospital.service.UpdatePatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

        @Autowired
    AddPatientService addPatientService;

        @Autowired
    PatientListService patientListService;

        @Autowired
    DeletePatientService deletePatientService;
@Autowired
    UpdatePatientService updatePatientService;


    @PostMapping("/addnewpatient")
    private String addNewPatient (@Valid @ModelAttribute("patients") Patient patient, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
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


    @GetMapping
    private String getAllPatients(Model model, @PageableDefault(size = 5) Pageable pageable) throws CommandException {
        model.addAttribute("patients", patientListService.getAllPatients(pageable));
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