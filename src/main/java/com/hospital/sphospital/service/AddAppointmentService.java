package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddAppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    PatientRepository patientRepository;

    @Transactional
    public Boolean addNewAppointment(Appointment appointment) {
        System.out.println(appointment.toString());
        appointmentRepository.save(appointment);

        return true;
    }


//    @Transactional
//    public Boolean addNewAppointment(Integer doctorId, Integer patientId, LocalDateTime appointmentData){

//        Appointment appointment = new Appointment();
//
//       Doctor doctor = doctorRepository.findById(doctorId);
//        Optional<Patient> patient = patientRepository.findById(patientId);
//
//        appointment.setDoctor(doctor);
//
//        System.out.println(appointment);
//        appointmentRepository.save(appointment);

//        return true;

//    }

}






