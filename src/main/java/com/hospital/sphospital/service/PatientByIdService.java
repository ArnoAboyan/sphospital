package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Log4j2
@RequiredArgsConstructor
public class PatientByIdService {


    private final PatientRepository patientRepository;

    @Transactional
    public Patient findByPatientId(Patient patient) {

        return patientRepository.findById(patient.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
    }


    @Transactional
    public Patient findByPatientIdInteger(int patientId) {


       Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));


        return patient;
    }
}