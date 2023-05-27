package com.hospital.sphospital.service;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateDoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Transactional
    public Boolean updateDoctor(Doctor doctor) throws CommandException {
        if (!doctorRepository.existsById(doctor.getDoctorId())) {
            throw new CommandException("Doctor not found");
        }
        doctorRepository.save(doctor);
        return true;
    }
}

