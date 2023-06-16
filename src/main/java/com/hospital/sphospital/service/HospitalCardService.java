package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalCardService {
   @Autowired
    HospitalCardRepository hospitalCardRepository;

   public HospitalCard getHospitalCardByDoctorIdAndPatientId (int doctorId, int patientId){
       return hospitalCardRepository.findByDoctorIdAndPatientId(doctorId,patientId);

   }
}
