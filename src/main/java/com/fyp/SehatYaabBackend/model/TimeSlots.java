package com.fyp.SehatYaabBackend.model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "time_slots")
public class TimeSlots {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slot_id;

    @ManyToOne
    @JoinColumn(name = "availability_id", nullable = false)
    @JsonBackReference("schedule_timeslots")
    AvailibilitySchedule availableschedule;




    @Column(nullable = false)
    private int token_no;


    @Column(nullable = false)
    private boolean isBooked;
    @OneToOne(mappedBy = "timeslot", cascade = CascadeType.ALL)
    @JsonBackReference
    private Appointment appointment;

    public TimeSlots() {

    }

    public TimeSlots(int slot_id, int token_no, boolean isBooked) {
        this.slot_id = slot_id;


        this.token_no = token_no;
        this.isBooked = isBooked;

    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public int getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(int slot_id) {
        this.slot_id = slot_id;
    }

    public AvailibilitySchedule getAvailableschedule() {
        return availableschedule;
    }

    public void setAvailableschedule(AvailibilitySchedule availableschedule) {
        this.availableschedule = availableschedule;
    }

    public int getToken_no(){
        return token_no;
    }


    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }


}
