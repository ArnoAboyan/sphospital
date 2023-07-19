package com.hospital.sphospital.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final PersonalUserDetailService personalUserDetailService;

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


    @PostMapping ("/process-login")
    public String authenticate(@RequestParam String login, @RequestParam String password) {
        try {
            personalUserDetailService.loadUserByUsername(login);
            return "redirect:/doctors";
        } catch (AuthenticationException e) {
            return "redirect:/login.html?error=true";
        }
    }


    @GetMapping("/roteuser")
    public String roteUser(){
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
                return "hello";
            }

            if (isAdmin) {
                return "redirect:/doctors/sessions";
            }



        } else {
            System.out.println("No active user");
        }
        return "testTemplate";

    }

}
