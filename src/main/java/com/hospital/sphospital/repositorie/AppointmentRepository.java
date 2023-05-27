package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query ("select a from Appointment a where a =:appointment_id")
    Page <Appointment> getAllAppiontments (Pageable pageable);

}
