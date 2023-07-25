package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import com.hospital.sphospital.service.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/hospitalcard")
public class HospitalCardController {


    private final HospitalCardService hospitalCardService;


    private final HospitalCardRepository hospitalCardRepository;

    private final AppointmentListService appointmentListService;

    private final DeletePatientService deletePatientService;


    private final DoctorByIdService doctorByIdService;


    private final PatientListByDoctorForAdminService patientListByDoctorForAdminService;


    @PostMapping
    private String getHospitalCard(@RequestParam("patientId") int patientId,
                                   @RequestParam("doctorId") int doctorId,
                                   Model model) {

        model.addAttribute("visitcard", appointmentListService.visitList(patientId, doctorId));
        model.addAttribute("hospitalcard", hospitalCardService.getHospitalCardByPatientId(patientId, doctorId));
        model.addAttribute("actualdoctor", doctorByIdService.findByDoctorIdInteger(doctorId));


        return "hospitalcard";
    }




    @PostMapping("/edit")
    public String updateHospitalCard(@RequestParam("hospitalcardid") int hospitalCardId,
                                     @RequestParam("doctorId") int doctorId,
                                     @RequestParam("procedures") String procedures,
                                     @RequestParam("medications") String medications,
                                     @RequestParam("operations") String operations,
                                     @RequestParam("diagnosis") String diagnosis,
                                     Model model) throws CommandException {


        hospitalCardService.updateHospitalCard(hospitalCardId, procedures, medications, operations, diagnosis);

        model.addAttribute("hospitalcard", hospitalCardService.actualHospitalCard());
        model.addAttribute("actualdoctor", doctorByIdService.findByDoctorIdInteger(doctorId));
        return "hospitalcard";
    }

    @PostMapping("/discharged")
    public String dischargedPatient(@RequestParam("patientId") int patientId,
                                     @RequestParam("doctorId") int doctorId,
                                    @PageableDefault(size = 5) Pageable pageable,
                                     Model model) throws CommandException {




            hospitalCardService.dischargedByPatientId(patientId);

       var doctor= doctorByIdService.findByDoctorIdInteger(doctorId);
        model.addAttribute("doctorById", doctor);
        model.addAttribute("patientsByDoctorId", patientListByDoctorForAdminService.findByDoctorId(doctor, pageable));
        return "patientlistbydoctoradmin";
    }

//    @GetMapping("/deleteall")
//public String deleteAll(){
//        hospitalCardRepository.deleteAll();
//        return "redirect:/doctors";
//    }


}

