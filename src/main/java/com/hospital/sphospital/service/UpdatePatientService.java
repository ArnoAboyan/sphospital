package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.PatientRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdatePatientService {

    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Boolean updatePatient (Patient patient) throws CommandException {

        if (!patientRepository.existsById(patient.getPatientId())) {
            throw new CommandException("Patient not found");
        }
        patientRepository.save(patient);
        return true;
    }
}
