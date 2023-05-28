package com.hospital.sphospital.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;



@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patientId;
    @Column(name = "appointments_data")
    @Future
    private LocalDateTime appointmentData;


    public Doctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Doctor doctorId) {
        this.doctorId = doctorId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDateTime getAppointmentData() {
        return appointmentData;
    }

    public void setAppointmentData(LocalDateTime appointmentData) {
        this.appointmentData = appointmentData;
    }


    //    @Transient
//    private String appointmentDoctorName;
//    @Transient
//    private String appointmentDoctorSurname;
//    @Transient
//    private Category appointmentDoctorCategory;
//    @Transient
//    private String appointmentPatientName;
//    @Transient
//    private String appointmentPatientSurname;


//    public Integer getAppointmentId() {
//        return appointmentId;
//    }
//
//    public void setAppointmentId(Integer appointmentId) {
//        this.appointmentId = appointmentId;
//    }
//
//    public int getDoctorId() {
//        return doctor_id;
//    }
//
//    public void setDoctorId(Integer doctorId) {
//        this.doctor_id = doctorId;
//    }
//
//    public Integer getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Integer patientId) {
//        this.patientId = patientId;
//    }
//
//    public LocalDateTime getAppointmentData() {
//        return appointmentData;
//    }
//
//    public void setAppointmentData(LocalDateTime appointmentData) {
//        this.appointmentData = appointmentData;
//    }

//    public String getAppointmentDoctorName() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return appointmentDoctorName =  doctor.getDoctorName();
//    }
//
//    public String getAppointmentDoctorSurname() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return appointmentDoctorSurname =  doctor.getDoctorSurname();
//    }
//
//    public Category getAppointmentDoctorCategory() throws DAOException {
//        Doctor doctor;
//        DoctorDao doctorDao = new DoctorDao();
//
//        doctor = doctorDao.getByID(doctorId);
//
//        return appointmentDoctorCategory =  doctor.getCategory();
//    }
//
//    public String getAppointmentPatientName() {
//        Patient patient;
//        PatientDao patientDao = new PatientDao();
//
//        patient = patientDao.getByID(patientId);
//
//        return appointmentDoctorSurname =  patient.getPatientName();
//    }
//    public String getAppointmentPatientSurname() {
//        Patient patient;
//        PatientDao patientDao = new PatientDao();
//
//        patient = patientDao.getByID(patientId);
//
//        return appointmentDoctorSurname =  patient.getPatientSurname();
//    }

//
//    public void setAppointmentDoctorName(String appointmentDoctorName) {
//        this.appointmentDoctorName = appointmentDoctorName;
//    }
//
//    public void setAppointmentDoctorSurname(String appointmentDoctorSurname) {
//        this.appointmentDoctorSurname = appointmentDoctorSurname;
//    }
//
//    public void setAppointmentDoctorCategory(Category appointmentDoctorCategory) {
//        this.appointmentDoctorCategory = appointmentDoctorCategory;
//    }
//
//    public void setAppointmentPatientName(String appointmentPatientName) {
//        this.appointmentPatientName = appointmentPatientName;
//    }
//
//    public void setAppointmentPatientSurname(String appointmentPatientSurname) {
//        this.appointmentPatientSurname = appointmentPatientSurname;
//    }
}
