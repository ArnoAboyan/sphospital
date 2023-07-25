package com.hospital.sphospital.service;


import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UpdateDoctorService {
    private final DoctorRepository doctorRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Boolean updateDoctor(Doctor doctor) throws CommandException {
        if (!doctorRepository.existsById(doctor.getDoctorId())) {
            throw new CommandException("Doctor not found");
        }

        doctor.setPassword(bCryptPasswordEncoder.encode(doctor.getPassword()));

        log.info( doctor.getDoctorId() + " <- Doctor has been successfully update");

        doctorRepository.save(doctor);
        return true;
    }
}

