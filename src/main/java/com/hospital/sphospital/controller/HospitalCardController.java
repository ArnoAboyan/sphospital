package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.service.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    DeletePatientService deletePatientService;

    @Autowired
    DoctorByIdService doctorByIdService;

    @Autowired
    PatientListByDoctorForAdminService patientListByDoctorForAdminService;


    @GetMapping
    private String getHospitalCard(@RequestParam("patientId") int doctorId,
                                   @RequestParam("doctorId") int patientId,
                                   Model model) {


        model.addAttribute("visitcard", appointmentListService.visitList(patientId, doctorId));
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

    @GetMapping("/discharged")
    public String dischargedPatient(@RequestParam("patientId") int patientId,
                                     @RequestParam("doctorId") int doctorId,
                                    @PageableDefault(size = 5) Pageable pageable,
                                     Model model) throws CommandException {


        System.out.println(patientId);
        System.out.println(doctorId);

        deletePatientService.patientDelete(patientId);

       var doctor= doctorByIdService.findByDoctorIdInteger(doctorId);
        model.addAttribute("doctorById", doctor);
        model.addAttribute("patientsByDoctorId", patientListByDoctorForAdminService.findByDoctorId(doctor, pageable));
        return "patientlistbydoctoradmin";
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

