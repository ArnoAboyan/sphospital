package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
