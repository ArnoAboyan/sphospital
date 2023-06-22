package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.service.AppointmentListService;
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

    @Autowired
    AppointmentListService appointmentListService;


    @GetMapping
    private String getHospitalCard(@RequestParam("patientId") int doctorId,
                                   @RequestParam("doctorId") int patientId,
                                   Model model) {



        model.addAttribute("visitcard", appointmentListService.visitList(patientId,doctorId));
        model.addAttribute("hospitalcard",
//                hospitalCardService.getHospitalCardByDoctorIdAndPatientId(doctorId.getDoctorId(), patientId.getPatientId()));
                hospitalCardService.getHospitalCardByDoctorIdAndPatientId(doctorId, patientId));




        return "hospitalcard";
    }





    @PostMapping("/edit")
    public String updateHospitalCard(@RequestParam("hospitalcardid") int hospitalCardId,
                                      @RequestParam("procedures") String procedures,
                                      @RequestParam("medications") String medications,
                                      @RequestParam("operations") String operations,
                                      @RequestParam("diagnosis") String diagnosis,
                                     Model model) throws CommandException {


        System.out.println(hospitalCardId);

        updateHospitalCadrService.updateHospitalCard(hospitalCardId, procedures, medications, operations, diagnosis);

        model.addAttribute("hospitalcard", updateHospitalCadrService.actualHospitalCard());
        return "hospitalcard";
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

