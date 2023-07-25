package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HospitalCardRepository extends JpaRepository<HospitalCard, Integer> {

//   HospitalCard findByDoctorDoctorIdAndPatientPatientId (int doctor, int patient);
//
//   HospitalCard deleteByDoctorDoctorIdAndPatientPatientId (int doctorId, int patientId);


    HospitalCard findByPatientPatientId (int patient);

    HospitalCard deleteByPatientPatientId (int patientId);

    boolean existsByPatient(Patient patient);



}
