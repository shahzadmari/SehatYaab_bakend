package com.fyp.SehatYaabBackend.dto;

public class ReviewRequestDTO {
    private int rating;
    private String comment;
    private String patientName;
    private String patienEmail;
    private String doctorId;

    public ReviewRequestDTO(int rating, String comment, String patientName, String patienEmail, String doctorId) {
        this.rating = rating;
        this.comment = comment;
        this.patientName = patientName;
        this.patienEmail = patienEmail;
        this.doctorId = doctorId;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatienEmail() {
        return patienEmail;
    }

    public void setPatienEmail(String patienEmail) {
        this.patienEmail = patienEmail;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
