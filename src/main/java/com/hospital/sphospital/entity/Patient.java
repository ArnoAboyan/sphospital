package com.hospital.sphospital.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "patient_name")
    @NotNull(message = "Patient name mast be fill")
    @Size(min = 3, max = 20, message = "The entered name size is not correct")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The entered name is not correct")
    private String patientName;
    @Column(name = "patient_surname")
    @NotNull(message = "Patient surname mast be fill")
    @Size(min = 3, max = 20, message = "The entered surname size is not correct")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The entered surname is not correct")
    private String patientSurname;
    @Column(name = "patient_date_of_birth")
    @NotNull(message = "Patient date of birth mast be fill")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    @Past(message = "Patient date of birth must be a past date")
    private Date patientDateOfBirth;
    @Column(name = "gender")
    @NotNull(message = "Patient gender mast be fill")
    @Pattern(regexp = "^(male|female)+$", message = "The entered gender is not correct")
    private String patientGender;
    @Column(name = "phone")
//    @NotNull(message = "Patient phone mast be fill")
    @Min(value = 11, message = "Quantity must be at least 11")
//    @Pattern(regexp = "^[8]{1}[0]{1}[0-9]{9}+$", message = "The entered phone is not correct")
//    @Digits(integer = 11, fraction = 0, message = "Quantity must be a 11-digit number")
    private Long patientPhone;


//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
//    private List<HospitalCard> hospitalCards;


    public int getPatientId() {
        return patientId;
    }


    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public Date getPatientDateOfBirth() {
        return patientDateOfBirth;
    }

    public void setPatientDateOfBirth(String patientDateOfBirth) {
        this.patientDateOfBirth = Date.valueOf(patientDateOfBirth);
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public Long getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(Long patientPhone) {
        this.patientPhone = patientPhone;
    }

//    public List<HospitalCard> getHospitalCards() {
//        return hospitalCards;
//    }
//
//    public void setHospitalCards(List<HospitalCard> hospitalCards) {
//        this.hospitalCards = hospitalCards;
//    }
}
