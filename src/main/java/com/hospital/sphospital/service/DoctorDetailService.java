//package com.hospital.sphospital.service;
//
//import com.hospital.sphospital.repositorie.DoctorRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service("userdetailserviceimplement")
//@RequiredArgsConstructor
//public class DoctorDetailService implements UserDetailsService {
//
//
//    private final DoctorRepository doctorRepository;
//
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println(doctorRepository.findDistinctByLogin(username));
//        return doctorRepository.findDistinctByLogin(username);
//    }
//
//
////    @Override
////    @Transactional
////    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
////        System.out.println(doctorRepository.findByDoctorNameFetchRoles(login));
////        return doctorRepository.findByDoctorNameFetchRoles(login);
////    }
//
//
//
//
//}
