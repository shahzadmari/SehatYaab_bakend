package com.fyp.SehatYaabBackend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "availabilityschedule")
public class AvailibilitySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int availability_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    @JsonBackReference("doctor_schedule")
    private Doctor doctor;


    @Column(nullable = false)
    private LocalDate date;


    @Column(nullable = false)
    private String day;


    @Column(nullable = false)
    private String appointmentType;


    @OneToMany(mappedBy = "availableschedule", cascade = CascadeType.ALL)
    @JsonManagedReference("schedule_timeslots")
    private List<TimeSlots> timeSlots;

    public AvailibilitySchedule() {
    }

    public AvailibilitySchedule(int availability_id, LocalDate date, String day, String appointmentType) {
        this.availability_id = availability_id;

        this.date = date;
        this.day = day;
        this.appointmentType = appointmentType;

    }

    public int getAvailability_id() {
        return availability_id;
    }

    public void setAvailability_id(int availability_id) {
        this.availability_id = availability_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public List<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
        for(TimeSlots slots : timeSlots){
            slots.setAvailableschedule(this);
        }
    }

    @Override
    public String toString() {
        return "AvailibilitySchedule{" +
                "availability_id=" + availability_id +
                ", doctor=" + doctor +
                ", date=" + date +
                ", day='" + day + '\'' +
                ", appointmentType='" + appointmentType + '\'' +

                '}';
    }
}
