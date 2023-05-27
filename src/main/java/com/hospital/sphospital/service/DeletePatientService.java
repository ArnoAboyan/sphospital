package com.hospital.sphospital.service;


import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DeletePatientService {
    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Boolean patientDelete(Integer patientId) {
        //validate input parameters
       if (patientId == 0){
           throw new NullPointerException("Can`t delete patient, because patient is null!");
       }
        patientRepository.deleteById(patientId);

        return true;
    }
}
