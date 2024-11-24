package com.fyp.SehatYaabBackend.controllers;


import com.fyp.SehatYaabBackend.model.Patient;
import com.fyp.SehatYaabBackend.service.impl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {


    private PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }


    @PostMapping("/apis/patient")
    ResponseEntity<Patient> savePatient(@RequestBody Patient patient){

        return new ResponseEntity<>(patientService.save(patient), HttpStatus.CREATED);

    }


    @GetMapping("/apis/getAllPatients")
    public List<Patient> getAllPatients() {

        return patientService.getAllPatients();
    }

    @DeleteMapping("/apis/deletePatient/{id}")
    public void deletePatient(@PathVariable String id){

        patientService.deletePatient(id);
    }


}
