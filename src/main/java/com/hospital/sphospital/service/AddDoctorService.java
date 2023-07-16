package com.hospital.sphospital.service;

import com.hospital.sphospital.auth.AuthenticationResponse;
import com.hospital.sphospital.auth.AuthenticationService;
import com.hospital.sphospital.auth.RegisterRequest;
import com.hospital.sphospital.config.JwtService;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Role;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AddDoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

//   @Transactional
//    public void addNewDoctor( Doctor doctor) {
//        System.out.println(doctor);
//        doctorRepository.save(doctor);
//    }

    public AuthenticationResponse addNewDoctor(Doctor doctor) {
//        Doctor doctor = Doctor
//                .builder()
//                .doctorName(request.getDoctorName())
//                .doctorSurname(request.getDoctorSurname())
//                .login(request.getLogin())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .role(Role.DOCTOR)
//                .category(request.getCategory())
//                .build();

        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        System.out.println(doctor);

        doctorRepository.save(doctor);
        var jwtToken = jwtService.generateToken(doctor);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


}
