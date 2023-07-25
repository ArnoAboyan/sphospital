package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import com.hospital.sphospital.repositorie.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log
@RequiredArgsConstructor
public class HospitalCardService {
    private final HospitalCardRepository hospitalCardRepository;

    private final DoctorByIdService doctorByIdService;

    private final AppointmentRepository appointmentRepository;
    private final PatientByIdService patientByIdService;

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    private HospitalCard hospitalCard;


    @Transactional
    public HospitalCard getHospitalCardByPatientId(int doctorId, int patientId) {


        Patient patient = patientByIdService.findByPatientIdInteger(doctorId);

//            log.info("Get hospital card -> " + hospitalCard);

        if (!isExistByPatient(patient)) {
            crateHospitalCard(patient);

        }
        log.info("HOSPITAL CARD HAS BEEN FIND");
        return hospitalCardRepository.findByPatientPatientId(patient.getPatientId());

    }

    @Transactional
    public Boolean crateHospitalCard(Patient patient) {

        HospitalCard hospitalCard = HospitalCard.builder().patient(patient).build();


        hospitalCardRepository.save(hospitalCard);
        log.info("NEW HOSPITAL CARD IS CREATED");
        return true;
    }


    @Transactional
    public Boolean updateHospitalCard(int hospitalCardId, String procedures, String medications, String operations, String diagnosis) throws CommandException {


        hospitalCard = hospitalCardRepository.findById(hospitalCardId).orElseThrow(() -> new NullPointerException("HospitalCard not found"));


        hospitalCard.setProcedures(procedures);
        hospitalCard.setOperations(operations);
        hospitalCard.setMedications(medications);
        hospitalCard.setDiagnosis(diagnosis);

        hospitalCardRepository.save(hospitalCard);

        log.info("Hospital card update successful");
        return true;
    }


    @Transactional
    public Boolean isExistByPatient(Patient patient) {

        return hospitalCardRepository.existsByPatient(patient);

    }

    @Transactional
    public Boolean dischargedByPatientId(int patientId) {

//        hospitalCardRepository.deleteByPatientPatientId(patientId);
        patientRepository.deleteById(patientId);

        log.info("hospital card successful has been deleted");


        return true;
    }

    public HospitalCard actualHospitalCard() {
        return hospitalCard;
    }
}