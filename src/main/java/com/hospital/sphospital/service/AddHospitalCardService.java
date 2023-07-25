//package com.hospital.sphospital.service;
//
//import com.hospital.sphospital.entity.Appointment;
//import com.hospital.sphospital.entity.Doctor;
//import com.hospital.sphospital.entity.HospitalCard;
//import com.hospital.sphospital.entity.Patient;
//import com.hospital.sphospital.exeption.CommandException;
//import com.hospital.sphospital.repositorie.DoctorRepository;
//import com.hospital.sphospital.repositorie.HospitalCardRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.java.Log;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.EnableMBeanExport;
//import org.springframework.stereotype.Service;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//public class AddHospitalCardService {
//
//    private final  HospitalCardRepository hospitalCardRepository;
//
//
//    private final  DoctorRepository doctorRepository;
//
//
//    public Boolean crateHospitalCard(Doctor doctor, Patient patient){
////    public Boolean crateHospitalCard(Appointment appointment){
//
//
////
////        Doctor doctor = appointment.getDoctorId();
////        Patient patient= appointment.getPatientId();
//
//
////        if (isExistByDoctorAndPatient(doctor,patient)){
////            log.info("HOSPITAL CARD IS FIND");
////            return false;
////
////        }
//        HospitalCard hospitalCard= new HospitalCard(patient, doctor);
//        System.out.println(hospitalCard);
//        hospitalCardRepository.save(hospitalCard);
//        log.info("NEW HOSPITAL CARD IS CREATED");
//        return true;
//    }
//
//    public Boolean isExistByDoctorAndPatient(Doctor doctor, Patient patient){
//
//        return hospitalCardRepository.existsByDoctorAndPatient(doctor, patient);
//
//    }
//
//
//
//}
