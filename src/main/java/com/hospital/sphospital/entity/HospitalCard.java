package com.hospital.sphospital.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;


@ToString
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "hospitalcards")
public class HospitalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospitalcard_id")
    private int hospitalCardId;
    @ManyToOne
    @JoinColumn(name = "patientid", referencedColumnName = "patient_id")
    @NonNull
    private Patient patient;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "doctorid", referencedColumnName = "doctor_id")
    private Doctor doctor;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "medications")
    private String medications;
    @Column(name = "operations")
    private String operations;

    public HospitalCard(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }
//
    public HospitalCard(int hospitalCardId, Patient patient,Doctor doctor, String diagnosis, String procedures, String medications, String operations) {
        this.hospitalCardId = hospitalCardId;
        this.patient = patient;
        this.doctor = doctor;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patientId) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctorId) {
        this.doctor = doctor;
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


}
