package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.validation.Valid;

@Service
public class AddDoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

   @Transactional
    public void addNewDoctor( Doctor doctor) {
        System.out.println(doctor);
        doctorRepository.save(doctor);
    }
}
