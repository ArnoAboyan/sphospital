package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentListService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorByIdService doctorByIdService;

    @Autowired
    PatientByIdService patientByIdService;


    @Transactional
    public Page<Appointment> getAllAppointments(Pageable pageable) throws CommandException {
        Page<Appointment> appointments = appointmentRepository.findAll(pageable);
        if (appointments.getSize() != 5) {
            throw new CommandException("Size is incorrect");
        }
        return appointments;
    }

    @Transactional
    public List<Appointment> visitList(int doctorId, int patientId) {


        Doctor doctor = doctorByIdService.findByDoctorIdInteger(doctorId);
        Patient patient = patientByIdService.findByPatientIdInteger(patientId);


        List<Appointment> appointmentList = appointmentRepository.findByDoctorIdAndPatientId(doctor, patient);
        System.out.println("!!!APPOINTMENT LIST => " + appointmentList);
        return appointmentList;
    }
}

