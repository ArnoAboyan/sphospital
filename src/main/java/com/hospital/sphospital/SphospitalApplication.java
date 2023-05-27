package com.hospital.sphospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
@Controller
public class SphospitalApplication {


	public static void main(String[] args) {
		SpringApplication.run(SphospitalApplication.class, args);


	}
}

