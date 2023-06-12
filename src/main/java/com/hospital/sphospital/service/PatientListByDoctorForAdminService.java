package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PatientListByDoctorForAdminService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;


    @Transactional
    public Page<Appointment> findByDoctorId (Doctor doctor, Pageable pageable){
        System.out.println(appointmentRepository.findByDoctorId(doctor, pageable));
        return appointmentRepository.findByDoctorId(doctor, pageable);
    }

}
