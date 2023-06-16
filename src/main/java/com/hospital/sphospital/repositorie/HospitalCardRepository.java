package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalCardRepository extends JpaRepository<HospitalCard, Integer> {

    HospitalCard findByDoctorIdAndPatientId (int doctorId, int patient);





}
