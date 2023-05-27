package com.hospital.sphospital.service;


import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteDoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Transactional
    public Boolean deleteDoctorById (Integer doctorid) {

    //validate input parameters
        if(doctorid == 0){
            throw new NullPointerException("Can`t delete doctor, because doctor is null!");
    }
        doctorRepository.deleteById(doctorid);
        return true;

}
}
