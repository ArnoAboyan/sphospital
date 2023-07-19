package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;

import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class AdminPageService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    AppointmentRepository appointmentRepository;



    @Transactional
    public Page<Doctor> getAllDoctors(Pageable pageable) throws CommandException {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);

        doctors.stream().forEach(doctor -> doctor.setCountOfPatients(appointmentRepository.countByDoctorId(doctor)));

        doctors.stream().forEach(System.out::println);

        if (doctors.getSize() != 5){
            throw new CommandException("Size is incorrect");
        }

        System.out.println(doctors);
        return doctors;
    }

    @Transactional
    public List<Doctor> getAllDoctorsForAppointments() throws CommandException {
        return doctorRepository.findAll();
    }



}