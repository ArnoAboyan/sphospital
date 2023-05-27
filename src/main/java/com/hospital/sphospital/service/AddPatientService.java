package com.hospital.sphospital.service;


import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddPatientService {

@Autowired
    PatientRepository patientRepository;

    @Transactional
     public boolean addNewPatient(Patient patient){
         System.out.println(patient);
         patientRepository.save(patient);
        return true;
     }


}
