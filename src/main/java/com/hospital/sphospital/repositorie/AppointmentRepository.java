package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Appointment;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.doctorId = :doctorId GROUP BY a.appointmentId")
    Page<Appointment> findByDoctorId(@Param("doctorId") Doctor doctor, Pageable pageable);


    int countByDoctorId(Doctor doctor);


}
