package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.service.HospitalCardService;
import com.hospital.sphospital.service.UpdateHospitalCadrService;
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

    @Autowired
    UpdateHospitalCadrService updateHospitalCadrService;


    @GetMapping
    private String getHospitalCard(@ModelAttribute("patientId") Doctor doctorId,
                                   @ModelAttribute("doctorId") Patient patientId,
                                   Model model) {


        model.addAttribute("hospitalcard",
                hospitalCardService.getHospitalCardByDoctorIdAndPatientId(doctorId.getDoctorId(), patientId.getPatientId()));

        return "hospitalcard";
    }

    @GetMapping("/edit")
    public String updateHospitalCard(@RequestParam("hospitalcard") int hospitalCardId,

                                     Model model) throws CommandException {


        System.out.println(hospitalCardId);

//        updateHospitalCadrService.updateHospitalCard(hospitalCardId);

        return "redirect:/hospitalcard";
    }



//    @GetMapping("/edit")
////    public String updateHospitalCard(@Valid @ModelAttribute("hospitalcard") HospitalCard hospitalCard,
////                                      BindingResult bindingResult,
////                                      Model model) throws CommandException {
////        if (bindingResult.hasErrors()) {
////            model.addAttribute("bindingResult", bindingResult);
////            return "error";
////        }
////
////        System.out.println(hospitalCard);
////
////        updateHospitalCadrService.updateHospitalCard(hospitalCard);
////
////        return "redirect:/hospitalcard";
////    }



}

