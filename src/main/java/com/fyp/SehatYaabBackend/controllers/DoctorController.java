package com.fyp.SehatYaabBackend.controllers;

import com.fyp.SehatYaabBackend.model.AvailibilitySchedule;
import com.fyp.SehatYaabBackend.model.Doctor;
import com.fyp.SehatYaabBackend.service.impl.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;


@RestController //This annotation make this class as controller which includes other annotations like @ResponseBody helps to send reponses to clients
public class DoctorController {

    DoctorServiceImpl doctorService;

    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }


    @PostMapping("/apis/doctor")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){





        return new ResponseEntity<>(doctorService.save(doctor), HttpStatus.CREATED);

    }

    @PostMapping("/apis/saveAvailibility/{doctorid}")
    public ResponseEntity<AvailibilitySchedule> saveAvailability(@PathVariable String doctorid,@RequestBody AvailibilitySchedule availibilitySchedule){
        return new ResponseEntity<>(doctorService.saveAvailability(doctorid,availibilitySchedule), HttpStatus.CREATED);
    }


    @GetMapping("/apis/getAllDoctor")
    public List<Doctor> getAllDoctor(){

        return doctorService.getAllDoctor();
    }

    @PostMapping("/apis/getOneDoctor/{id}")
    public Doctor getDoctor(@PathVariable String id){

        return doctorService.getDoctor(id);
    }



    @DeleteMapping("/apis/deleteDoctor/{id}")
    public void deleteBYid(@PathVariable String id){

        doctorService.removeDoctor(id);
    }



}
