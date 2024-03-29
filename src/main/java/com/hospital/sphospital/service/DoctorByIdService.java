package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorByIdService {


    private final DoctorRepository doctorRepository;

    @Transactional
    public Doctor findByDoctorId(Doctor innerdoctor) {


        return doctorRepository.findById(innerdoctor.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    @Transactional
    public Doctor findByDoctorIdInteger(int innerdoctor) {


        return doctorRepository.findById(innerdoctor).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }
}

