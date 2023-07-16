package com.hospital.sphospital.auth;

import com.hospital.sphospital.config.JwtService;
import com.hospital.sphospital.repositorie.DoctorRepository;
import com.hospital.sphospital.entity.Doctor;
import com.hospital.sphospital.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        Doctor doctor = Doctor
                .builder()
                .doctorName(request.getDoctorName())
                .doctorSurname(request.getDoctorSurname())
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .category(request.getCategory())
                .build();
        doctorRepository.save(doctor);
        var jwtToken = jwtService.generateToken(doctor);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        var user = doctorRepository.findByLogin(request.getLogin()).orElseThrow();
        System.out.println("DOCTOR ------>" + user);
        var jwtToken = jwtService.generateToken(user);
        System.out.println("TOKEN ----> " + jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
