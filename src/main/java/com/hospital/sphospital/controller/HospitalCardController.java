package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.service.HospitalCardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hospitalcard")
public class HospitalCardController {

    @Autowired
    HospitalCardService hospitalCardService;


    @GetMapping
    private String getHospitalCard(@ModelAttribute("patientId") Doctor doctorId,
                                   @ModelAttribute("doctorId") Patient patientId,
                                   Model model) {


        model.addAttribute("hospitalcard",
                hospitalCardService.getHospitalCardByDoctorIdAndPatientId(doctorId.getDoctorId(), patientId.getPatientId()));


        return "hospitalcard";
    }
}

//        @PostMapping
//    private String getHospitalCard(@Valid @ModelAttribute("patient") Patient patient,
//                                   @ModelAttribute("doctor") Doctor doctor,
//                                   BindingResult bindingResult,
//                                   Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("bindingResult", bindingResult);
//            return "error";
//        }
//            model.addAttribute("hospitalcard",
//                hospitalCardService.getHospitalCardByDoctorIdAndPatientId(doctor, patient));
//
//        System.out.println(model);
//
//        return"redirect:/hospitalcard";
//    }
//
//
//}
