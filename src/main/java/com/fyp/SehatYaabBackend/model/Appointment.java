package com.fyp.SehatYaabBackend.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentid;



    @Column(nullable = false)
    private LocalDate appointment_date;

    @Column(nullable = false)
    private String appointment_day;

    @Column(nullable = false)
    private String appointment_type;

    @Column(nullable = false)
    private String appointment_status;

    @Column(name = "patient_id",nullable = false)
    private String  patient;



    @Column(name = "doctor_id", nullable = false)
    private String doctor;


    @OneToOne
    @JoinColumn(name = "slot_id")
    @JsonManagedReference
    private TimeSlots timeslot;

    public Appointment() {
    }

    public Appointment(int appointmentid, LocalDate appointment_date, String appointment_day,String appointment_status, String appointment_type, String patient, String doctor, TimeSlots timeslot) {
        this.appointmentid = appointmentid;
        this.appointment_date = appointment_date;
        this.appointment_day = appointment_day;
        this.appointment_status = appointment_status;
        this.appointment_type = appointment_type;
        this.patient = patient;
        this.doctor = doctor;
        this.timeslot = timeslot;
    }

    public int getAppointmentid() {
        return appointmentid;
    }

    public void setAppointmentid(int appointmentid) {
        this.appointmentid = appointmentid;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_day() {
        return appointment_day;
    }

    public String getAppointment_status() {
        return appointment_status;
    }

    public void setAppointment_status(String appointment_status) {
        this.appointment_status = appointment_status;
    }

    public void setAppointment_day(String appointment_day) {
        this.appointment_day = appointment_day;
    }

    public String getAppointment_type() {
        return appointment_type;
    }

    public void setAppointment_type(String appointment_type) {
        this.appointment_type = appointment_type;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public TimeSlots getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlots timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentid=" + appointmentid +
                ", appointment_date=" + appointment_date +
                ", appointment_day='" + appointment_day + '\'' +
                ", appointment_type='" + appointment_type + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", timeslot=" + timeslot +
                '}';
    }
}
