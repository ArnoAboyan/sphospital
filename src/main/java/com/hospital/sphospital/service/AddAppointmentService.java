package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.Appointment;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import com.hospital.sphospital.repositorie.AppointmentRepository;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import com.hospital.sphospital.repositorie.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor

 public class AddAppointmentService {

    private final AppointmentRepository appointmentRepository;


    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;







    private final HospitalCardRepository hospitalCardRepository;

    @Transactional
    public Boolean addNewAppointment(Appointment appointment) {

        appointmentRepository.save(appointment);
        log.info("Create new appointment -> " + appointment.getDoctorId() + " / "
                + appointment.getPatientId() + " / " + appointment.getAppointmentData());
//        addHospitalCardService.crateHospitalCard(appointment);
//        log.info("Hospital card has been successfully created");
        return true;
    }



}






