package com.hospital.sphospital.service;


import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AddPatientService {

private final PatientRepository patientRepository;

    @Transactional
     public boolean addNewPatient(Patient patient){

         patientRepository.save(patient);
        return true;
     }


}
