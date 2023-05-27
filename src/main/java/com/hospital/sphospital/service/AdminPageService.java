package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;

import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AdminPageService {

    @Autowired
    private DoctorRepository doctorRepository;



@Transactional
    public Page<Doctor> getAllDoctors(Pageable pageable) throws CommandException {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        if (doctors.getSize() != 5){
            throw new CommandException("Size is incorrect");
        }
        return doctors;
    }

}