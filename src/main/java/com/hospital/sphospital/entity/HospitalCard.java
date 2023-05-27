package com.hospital.sphospital.entity;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@Entity
@Table(name = "hospitalcards")
public class HospitalCard {
    @Id
    @Column(name = "hospitalcard_id")
    private int hospitalCardId;
    @Column(name = "patientid")
    private int patientId;
    @Column(name = "doctorid")
    private int doctorId;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "medications")
    private String medications;
    @Column(name = "operations")
    private String operations;
    @Transient
    private String patientNameById;
    @Transient
    private String patientSurnameById;
    @Transient
    private String doctorNameById;
    @Transient
    private String doctorSurnameById;

    @Transient
    private Category doctorCategoryById;
    @Transient
    private Date patientDateOfBirth;



    public HospitalCard(int patientId, int doctorId, String diagnosis, String procedures, String medications, String operations) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.diagnosis = diagnosis;
        this.procedures = procedures;
        this.medications = medications;
        this.operations = operations;
    }

    public int getHospitalCardId() {
        return hospitalCardId;
    }

    public void setHospitalCardId(int hospitalCardId) {
        this.hospitalCardId = hospitalCardId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

//    public String getPatientNameById() {
//        Patient patient;
//        PatientDao patientDao = new PatientDao();
//
//        patient = patientDao.getByID(patientId);
//
//        return patientNameById =  patient.getPatientName();
//
//    }
//
//
//    public String getPatientSurnameById() {
//        Patient patient;
//        PatientDao patientDao = new PatientDao();
//
//        patient = patientDao.getByID(patientId);
//
//        return patientSurnameById =  patient.getPatientSurname();
//
//    }
//
//
//    public String getDoctorNameById() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return doctorNameById =  doctor.getDoctorSurname();
//    }
//
//
//    public String getDoctorSurnameById() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return doctorSurnameById =  doctor.getDoctorName();
//    }
//    public String getDoctorCategoryById() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return doctorSurnameById = String.valueOf(doctor.getCategory());
//    }
//
//    public Date getPatientDateOfBirth() {
//        Patient patient;
//        PatientDao patientDao = new PatientDao();
//
//        patient = patientDao.getByID(patientId);
//
//        return patientDateOfBirth =  patient.getPatientDateOfBirth();
//    }

}
