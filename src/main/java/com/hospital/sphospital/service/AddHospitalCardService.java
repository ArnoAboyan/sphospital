package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;

@Service
public class AddHospitalCardService {
    @Autowired
    HospitalCardRepository hospitalCardRepository;

    @Autowired
    DoctorRepository doctorRepository;


    public Boolean crateHospitalCard(Doctor doctor, Patient patient){


        return true;
    }





}
