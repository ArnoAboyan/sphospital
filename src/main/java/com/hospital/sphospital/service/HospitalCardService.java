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

    @Autowired
    DoctorByIdService doctorByIdService;

    @Autowired
    PatientByIdService patientByIdService;

   public HospitalCard getHospitalCardByDoctorIdAndPatientId (int patientId, int doctorid){



       Doctor doctor = doctorByIdService.findByDoctorIdInteger(doctorid);
       Patient patient = patientByIdService.findByPatientIdInteger(patientId);

       return hospitalCardRepository.findByDoctorDoctorIdAndPatientPatientId(doctor.getDoctorId(),patient.getPatientId());

   }
}
