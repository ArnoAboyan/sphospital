package com.hospital.sphospital.entity;


import jakarta.persistence.*;
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
    @Column(name = "hospitalcard_id")
    private int hospitalCardId;
    @ManyToOne
    @JoinColumn(name = "patientid")
    @NonNull
    private Patient patient;
    @ManyToOne
    @NonNull
    @JoinColumn(name = "doctorid")
    private Doctor doctor;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "procedures")
    private String procedures;
    @Column(name = "medications")
    private String medications;
    @Column(name = "operations")
    private String operations;


//    @Transient
//    private String patientNameById;
//    @Transient
//    private String patientSurnameById;
//    @Transient
//    private String doctorNameById;
//    @Transient
//    private String doctorSurnameById;
//
//    @Transient
//    private Category doctorCategoryById;
//    @Transient
//    private Date patientDateOfBirth;



//    public HospitalCard(Patient patientId, Doctor doctorId, String diagnosis, String procedures, String medications, String operations) {
//        this.patientId = patientId;
//        this.doctorId = doctorId;
//        this.diagnosis = diagnosis;
//        this.procedures = procedures;
//        this.medications = medications;
//        this.operations = operations;
//    }

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
