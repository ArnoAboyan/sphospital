package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
