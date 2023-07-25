package com.hospital.sphospital.service;

//import com.hospital.sphospital.auth.AuthenticationResponse;
//import com.hospital.sphospital.auth.AuthenticationService;
//import com.hospital.sphospital.auth.RegisterRequest;
//import com.hospital.sphospital.config.JwtService;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Role;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Log4j2
public class AddDoctorService {

    private final DoctorRepository doctorRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

@Transactional
    public Boolean addNewDoctor(Doctor doctor) {

        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));


        log.info("New doctor has been successfully added");

        doctorRepository.save(doctor);
        return true;
    }




}
