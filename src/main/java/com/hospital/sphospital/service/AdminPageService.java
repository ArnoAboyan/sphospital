package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;

import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@RequiredArgsConstructor
@Log4j2
public class AdminPageService {

    private final DoctorRepository doctorRepository;

    private final AppointmentRepository appointmentRepository;



    @Transactional
    public Page<Doctor> getAllDoctors(Pageable pageable) throws CommandException {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);

        doctors.stream().forEach(doctor -> doctor.setCountOfPatients(appointmentRepository.countByDoctorId(doctor)));

        if (doctors.getSize() != 5){
            log.error("Size is incorrect");
            throw new CommandException("Size is incorrect");
        }


        return doctors;
    }

    @Transactional
    public List<Doctor> getAllDoctorsForAppointments() throws CommandException {
        return doctorRepository.findAll();
    }



}