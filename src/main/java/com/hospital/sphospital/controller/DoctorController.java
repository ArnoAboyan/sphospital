package com.hospital.sphospital.controller;


import com.hospital.sphospital.auth.PersonalUserDetailService;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.service.DoctorByIdService;
import com.hospital.sphospital.service.DoctorPageService;
import com.hospital.sphospital.service.PatientListByDoctorForAdminService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/doctorpage")
public class DoctorController {

    private final PatientListByDoctorForAdminService patientListByDoctorForAdminService;

    private final DoctorByIdService doctorByIdService;

    private final DoctorPageService doctorPageService;

    @GetMapping()
    public String allPatientsByDoctor(@RequestParam("doctorlogin") String doctorLogin,
                                      @PageableDefault(size = 5)
                                      Principal doctorSession,
                                      Pageable pageable,
                                      Model model) {


        if (!doctorLogin.equalsIgnoreCase(doctorSession.getName())) {
                throw new IllegalArgumentException("Incorrect doctor");
        }
            Sort sort = pageable.getSort();

            List<Sort.Order> orders = sort.toList();
            for (Sort.Order order : orders) {
                String sortName = order.getProperty();
                model.addAttribute("sortName", sortName);
            }

            Doctor doctorByLogin = doctorPageService.getDoctorByLogin(doctorLogin);
            System.out.println(doctorByLogin);

            model.addAttribute("doctorById", doctorByLogin);
            System.out.println(patientListByDoctorForAdminService.findByDoctorId(doctorByLogin, pageable));

            model.addAttribute("patientsByDoctorId", patientListByDoctorForAdminService.findByDoctorId(doctorByLogin, pageable));
            return "patientlistbydoctor";

        }
}
