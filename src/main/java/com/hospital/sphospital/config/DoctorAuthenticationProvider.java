//package com.hospital.sphospital.config;
//
//
//import com.hospital.sphospital.entity.Doctor;
//import com.hospital.sphospital.repositorie.DoctorRepository;
//import com.hospital.sphospital.service.PersonalUserDetailService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class DoctorAuthenticationProvider implements AuthenticationProvider {
//
//    private final PersonalUserDetailService doctorDetailService;
//
//    private final PasswordEncoder passwordEncoder = bCryptPasswordEncoder();
//
//
//    @Bean
//    BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        UserDetails userDetails = doctorDetailService.loadUserByUsername(username);
//
//        System.out.println(userDetails);
//
//        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Invalid password");
//        }
//
//        UsernamePasswordAuthenticationToken authenticatedToken = new UsernamePasswordAuthenticationToken(
//                userDetails, password, userDetails.getAuthorities());
//        authenticatedToken.setDetails(username); // Установка имени пользователя в details
//
//        return authenticatedToken;
//
//
////        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
//    }
//
//
//}
