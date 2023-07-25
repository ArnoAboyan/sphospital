package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoctorPageService {

    private final DoctorRepository doctorRepository;


    @Transactional
    public Doctor getDoctorByLogin (String login){

        return doctorRepository.findDistinctByLogin(login);
    }





}
