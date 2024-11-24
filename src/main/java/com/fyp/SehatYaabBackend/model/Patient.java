package com.fyp.SehatYaabBackend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private String patientid;

    @Column(name = "email_id",nullable = false)
    private String emailid;



    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateofbirth;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "location",nullable = false)
    private String location;





    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;


    //The constructors are essential to create otherwise jpa will throw an exception
    public Patient() {

        createdAt = LocalDate.now();
        updatedAt = LocalDate.now();
    }

    public Patient(String patientid, String emailid, String name, LocalDate dateofbirth, String gender, String location) {
        this.patientid = patientid;
        this.emailid = emailid;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
        this.location = location;


    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "patientid=" + patientid +
                ", emailid='" + emailid + '\'' +
                ", name='" + name + '\'' +
                ", dateofbirth=" + dateofbirth +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +

                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
