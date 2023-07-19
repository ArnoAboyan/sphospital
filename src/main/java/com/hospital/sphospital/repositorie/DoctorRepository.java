package com.hospital.sphospital.repositorie;

import com.hospital.sphospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

        Doctor findDistinctByLogin (String login);



}
