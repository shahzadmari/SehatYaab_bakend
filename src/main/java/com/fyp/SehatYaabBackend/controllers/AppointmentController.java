package com.fyp.SehatYaabBackend.controllers;


import com.fyp.SehatYaabBackend.dto.AppointmentRequest;
import com.fyp.SehatYaabBackend.dto.AppointmentResponseDTO;
import com.fyp.SehatYaabBackend.model.Appointment;
import com.fyp.SehatYaabBackend.service.impl.AppointmentServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {


    AppointmentServiceImpl appointmentService;


    public AppointmentController(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/apis/bookAppointment")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody AppointmentRequest request){

        return new ResponseEntity<>(appointmentService.bookAppointment(request), HttpStatus.CREATED);
    }


    @DeleteMapping("/apis/deleteAppointment/{id}")
    public void deleteAppointment(@PathVariable("id") int id){

        appointmentService.deleteAppointment(id);
    }

    @PostMapping("/apis/getAllPatientAppointments/{id}")
    List<AppointmentResponseDTO> getAllPatientAppointments(@PathVariable String id){

        return appointmentService.getAppointmentsByPatientId(id);
    }

    @PostMapping("/apis/getAllDoctorAppointments/{id}")
    List<AppointmentResponseDTO> getAllDoctorAppointments(@PathVariable String id){

        return appointmentService.getAppointmentsByDoctorId(id);
    }


    @GetMapping("/apis/getAllAppointments")
    List<Appointment> getAllAppointments(){

        return appointmentService.getAllAppointments();
    }





}
