package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Appointment;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

//ALL PATIENT BY DOCTOR WITHOUT REPEATS
@Query("SELECT DISTINCT a.patientId FROM Appointment a WHERE a.doctorId = :doctorId")
    Page<Appointment> findByDoctorId(@Param("doctorId") Doctor doctor, Pageable pageable);


// COUNT OF PATIENT BY DOCTOR WITH DISTINCT (INT)
   @Query("SELECT COUNT(DISTINCT a.patientId) FROM Appointment a WHERE a.doctorId = :doctorId")
    int countByDoctorId(@Param("doctorId") Doctor doctor);

//    @Query("SELECT a FROM Appointment a WHERE a.doctorId = :doctorId AND a.patientId= :patientId")
    List<Appointment> findByDoctorIdAndPatientId (Doctor doctorId,Patient patientId);
}
