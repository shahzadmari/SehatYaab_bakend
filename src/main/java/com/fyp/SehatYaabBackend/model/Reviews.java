package com.fyp.SehatYaabBackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Reviews{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(nullable = false)
    private int rating; // e.g., from 1 to 5

    @Column(length = 500 , nullable = false)
    private String comment;

    @Column(nullable = false, updatable = false)
    private String patientName;

    @Column(nullable = false, updatable = false)
    private String patienEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    @JsonBackReference("doctor-reviews")
    private Doctor doctor;


    private LocalDateTime createdAt = LocalDateTime.now();

    public Reviews() {


    }

    public Reviews(int reviewId, int rating, String comment, String patientId, String patienEmail , Doctor doctor, LocalDateTime createdAt) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.patientName = patientId;
        this.patienEmail = patienEmail;
        this.doctor = doctor;
        this.createdAt = createdAt;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPatienEmail() {
        return patienEmail;
    }

    public void setPatienEmail(String patienEmail) {
        this.patienEmail = patienEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientId) {
        this.patientName= patientId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "reviewId=" + reviewId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", patientId='" + patientName + '\'' +
                ", doctor=" + doctor +
                ", createdAt=" + createdAt +
                '}';
    }

    // Getters and setters
}
