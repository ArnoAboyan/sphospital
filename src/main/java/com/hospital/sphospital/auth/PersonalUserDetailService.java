package com.hospital.sphospital.auth;

import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.repositorie.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalUserDetailService implements UserDetailsService {
//
//
    private final DoctorRepository doctorRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        return doctorRepository.findDistinctByLogin(login);
//    }



    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        try {
            final Doctor doctor = this.doctorRepository.findDistinctByLogin(username);
            if (doctor != null) {

                System.out.println(doctor);

                return User.withUsername(doctor.getLogin()).
                        accountLocked(!doctor.isEnabled()).
                        password(doctor.getPassword()).roles(doctor.getRole().name()).build();
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }
}


