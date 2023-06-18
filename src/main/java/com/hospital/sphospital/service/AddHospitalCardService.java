package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
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


    public Boolean crateHospitalCard(Appointment appointment){



        Doctor doctor = appointment.getDoctorId();
        Patient patient= appointment.getPatientId();

        if (isExistByDoctorAndPatient(doctor,patient)){
            System.out.println("!!! HOSPITAL CARD IS FIND");
            return false;
        }
        HospitalCard hospitalCard= new HospitalCard(patient, doctor);
        System.out.println(hospitalCard);
        hospitalCardRepository.save(hospitalCard);
        System.out.println("!!! NEW HOSPITAL CADR IS CREATED");
        return true;
    }

    private Boolean isExistByDoctorAndPatient(Doctor doctor, Patient patient){

        return hospitalCardRepository.existsByDoctorAndPatient(doctor, patient);

    }



}
