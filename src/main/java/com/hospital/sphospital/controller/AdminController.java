package com.hospital.sphospital.controller;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.service.AddDoctorService;
import com.hospital.sphospital.service.AdminPageService;
import com.hospital.sphospital.service.DeleteDoctorService;
import com.hospital.sphospital.service.UpdateDoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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
    private HttpServletRequest request;
    ;

//@PostMapping("/addnewdoctor")
//    private String addNewDoctor (@RequestParam("doctorName") String doctorName,
//                                 @RequestParam("doctorSurname") String doctorSurname,
//                                 @RequestParam("login") String login,
//                                 @RequestParam("password") String password,
//                                 @RequestParam("category") Integer category,
//                                 @RequestParam("role") Integer role)
//                                  throws CommandException{
//      addDoctorService.addNewDoctor(doctorName,doctorSurname,login,password,category,role);
//       return "redirect:/doctors/alldoctors";
//    }


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
    private String getAllDoctors(Model model, @PageableDefault(size = 5) Pageable pageable) throws CommandException {
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
}
