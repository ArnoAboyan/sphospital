package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class AppointmentListService {


    private final  AppointmentRepository appointmentRepository;


    private final  DoctorByIdService doctorByIdService;


    private final  PatientByIdService patientByIdService;


    @Transactional
    public Page<Appointment> getAllAppointments(Pageable pageable) throws CommandException {
        Page<Appointment> appointments = appointmentRepository.findAll(pageable);
        if (appointments.getSize() != 5) {
            throw new CommandException("Size is incorrect");
        }
        log.info("Appointment list has been get correctly");
        return appointments;
    }

    @Transactional
    public List<Appointment> visitList(int patientId, int doctorId) {


        Doctor doctor = doctorByIdService.findByDoctorIdInteger(doctorId);
        Patient patient = patientByIdService.findByPatientIdInteger(patientId);

        List<Appointment> appointmentList = appointmentRepository.findByDoctorIdAndPatientId(doctor, patient);
        log.info("Visit list has been get correctly");
        return appointmentList;
    }
}

