package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Log4j2
public class PatientListByDoctorForAdminService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;


    @Transactional
    public Page<Appointment> findByDoctorId (Doctor doctor, Pageable pageable){
            log.info("start PatientListByDoctorForAdminService");
        System.out.println(appointmentRepository.findByDoctorId(doctor, pageable));
        return appointmentRepository.findByDoctorId(doctor, pageable);
    }

}
