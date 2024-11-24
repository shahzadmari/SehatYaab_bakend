package com.fyp.SehatYaabBackend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.cglib.core.Local;

import javax.security.auth.callback.LanguageCallback;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) this is used when you want auto incremented primary key
    private String doctor_id;

    @Column(nullable = false)
    private String doctor_name;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String experience_years;

    @Column(nullable = false)
    private  String gender;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String hospital_address;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference("doctor_schedule")
    private List<AvailibilitySchedule> availibilitySchedule;


    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("doctor-reviews")
    private List<Reviews> reviews = new ArrayList<>();

    @Transient // Not persisted in the database
    private Double averageRating;

    private LocalDate created_at;
    private LocalDate updated_at;

    public Doctor() {
        created_at = LocalDate.now();
        updated_at = LocalDate.now();
    }
    public Doctor(String doctor_id, String doctor_name, String specialization, String email, String experience_years, String gender, String location, String hospital_address) {
        this.doctor_id = doctor_id;
        this.doctor_name = doctor_name;
        this.specialization = specialization;
        this.email = email;
        this.experience_years = experience_years;
        this.gender = gender;
        this.location = location;
        this.hospital_address = hospital_address;

    }



    public Double getAverageRating() {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }
        return reviews.stream()
                .mapToInt(Reviews::getRating)
                .average()
                .orElse(0.0);
    }

    public void setAverageRating(Double averageRating) {
        // No-op, required for serialization
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience_years() {
        return experience_years;
    }

    public void setExperience_years(String experience_years) {
        this.experience_years = experience_years;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHospital_address() {
        return hospital_address;
    }

    public void setHospital_address(String hospital_address) {
        this.hospital_address = hospital_address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<AvailibilitySchedule> getAvailibilitySchedule() {
        return availibilitySchedule;
    }

    public void setAvailibilitySchedule(List<AvailibilitySchedule> availibilitySchedule) {
        this.availibilitySchedule = availibilitySchedule;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", doctor_name='" + doctor_name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", email='" + email + '\'' +
                ", experience_years='" + experience_years + '\'' +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                ", hospital_address='" + hospital_address + '\'' +

                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
