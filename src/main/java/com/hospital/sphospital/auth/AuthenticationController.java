package com.hospital.sphospital.auth;


import com.hospital.sphospital.controller.DoctorController;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.service.DoctorPageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@SessionAttributes("userData")
public class AuthenticationController {

    private final PersonalUserDetailService personalUserDetailService;

    private final DoctorRepository doctorRepository;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


//    @GetMapping("/getsession")
//    public String getSession(HttpSession httpSession){
//        Enumeration<String> attributeNames = httpSession.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            Object attributeValue = httpSession.getAttribute(attributeName);
//            System.out.println(attributeName + ": " + attributeValue);
//        }
//
//        return "testTemplate";
//    }


    @PostMapping("/process-login")
    public String authenticate(@RequestParam String login, @RequestParam String password) {
        try {
            personalUserDetailService.loadUserByUsername(login);
            return "redirect:/doctors";
        } catch (AuthenticationException e) {
            return "redirect:/login.html?error=true";
        }
    }


    @GetMapping("/roteuser")
    public String roteUser(RedirectAttributes redirectAttributes) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            System.out.println("Active User: " + userDetails.getUsername());
            System.out.println("Authorities: " + userDetails.getAuthorities());

            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

            boolean isDoctor = authorities.stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_DOCTOR"));

            boolean isAdmin = authorities.stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));


            if (isDoctor) {

                redirectAttributes.addAttribute("doctorlogin", userDetails.getUsername());




                return "redirect:/doctorpage";

            }

            if (isAdmin) {
                return "redirect:/doctors";
            }


        } else {
            System.out.println("No active user");
        }
        return "error";

    }


    public void createUserData(@ModelAttribute String person) {

        System.out.println("============>" + person);

    }
}