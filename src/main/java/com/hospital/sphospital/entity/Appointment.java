package com.hospital.sphospital.entity;


import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

}
