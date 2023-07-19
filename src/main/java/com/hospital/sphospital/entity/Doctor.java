package com.hospital.sphospital.entity;


import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;


@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="doctors")
public class Doctor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "doctor_name")
    @NonNull
    @Size(min = 3, max = 20, message = "The entered name size is not correct")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The entered name is not correct")
    private String doctorName;

    @Column(name = "doctor_surname")
    @NonNull
    @Size (min = 3, max = 20, message = "The entered surname size is not correct")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "The entered surname is not correct")
    private String doctorSurname;

    @Column(name = "login")
    @NonNull
    @Size(min = 4, max = 20 , message = "The entered login size is not correct")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "The entered login is not correct")
    private String login;

    @Column(name = "password")
    @NonNull
    @Size(min = 4, max = 20, message = "The entered password size is not correct")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "The entered password is not correct")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    @NonNull
//    @Size(min = 0, max = 7, message = "The entered category is not correct")
    private Category category;


    @Enumerated(EnumType.ORDINAL)
    @NonNull
//    @Size(min = 0, max = 2, message = "The entered role is not correct")
    private Role role;


    @Column(name = "countofpatients")
    private int countOfPatients;


    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(int id) {
        if (id == 0) {
            this.role = Role.ADMIN;
        } else if (id == 1) {
            this.role = Role.DOCTOR;
        } else if (id == 2) {
            this.role = Role.NURSE;
        } else {
            throw new IllegalArgumentException("Incorrect id, do not have role for this" + id);
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(int id) {
        if (id == 0) {
            this.category = Category.ONKOLOGIST;
        } else if (id == 1) {
            this.category = Category.TRAUMATOLOGIST;
        } else if (id == 2) {
            this.category = Category.OPHTHALMOLOGIST;
        } else if (id == 3) {
            this.category = Category.DENTIST;
        } else if (id == 4) {
            this.category = Category.PSYCHIATRIST;
        } else if (id == 5) {
            this.category = Category.THERAPIST;
        } else if (id == 6) {
            this.category = Category.PEDIATRICIAN;
        } else if (id == 7) {
            this.category = Category.NURSE;
        } else {
            throw new IllegalArgumentException("Incorrect id, do not have role for this" + id);
        }
    }

    public int getCountOfPatients() {
        return countOfPatients;
    }

    public void setCountOfPatients(int countOfPatients) {
        this.countOfPatients = countOfPatients;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}