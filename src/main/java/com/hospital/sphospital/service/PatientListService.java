package com.hospital.sphospital.service;


import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PatientListService {

    @Autowired
  private PatientRepository patientRepository;

        public Page<Patient> getAllPatients (Pageable pageable) throws CommandException {
            Page<Patient> patients = patientRepository.findAll(pageable);
            if (patients.getSize() != 5){
                throw new CommandException("Size is incorrect");
            }
            return patients;
        }


}
