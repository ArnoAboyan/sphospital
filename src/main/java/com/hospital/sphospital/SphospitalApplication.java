package com.hospital.sphospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;

import java.util.List;

@SpringBootApplication
@EnableWebSecurity
public class SphospitalApplication {


	public static void main(String[] args) {
		SpringApplication.run(SphospitalApplication.class, args);


	}
}

