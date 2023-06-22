package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class PatientByIdService {

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public Patient findByPatientId(Patient innerpatient) {


        return patientRepository.findById(innerpatient.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
    }


    @Transactional
    public Patient findByPatientIdInteger(int innerpatient) {

        return patientRepository.findById(innerpatient).orElseThrow(() -> new RuntimeException("Patient not found"));
    }
}