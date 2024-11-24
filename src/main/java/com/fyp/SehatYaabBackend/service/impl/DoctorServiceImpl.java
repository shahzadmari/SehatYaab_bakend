package com.fyp.SehatYaabBackend.service.impl;


import com.fyp.SehatYaabBackend.model.AvailibilitySchedule;
import com.fyp.SehatYaabBackend.model.Doctor;
import com.fyp.SehatYaabBackend.repository.AvailabilityScheduleRepository;
import com.fyp.SehatYaabBackend.repository.DoctorRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorServiceImpl {


    private DoctorRepository doctorRepository;
    private AvailabilityScheduleRepository availabilityScheduleRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository, AvailabilityScheduleRepository availibilityScheduleRepository) {
        this.doctorRepository = doctorRepository;
        this.availabilityScheduleRepository = availibilityScheduleRepository;
    }


    public Doctor save(Doctor doctor){

        for (AvailibilitySchedule schedule : doctor.getAvailibilitySchedule()){

            schedule.setDoctor(doctor);
            schedule.setTimeSlots(schedule.getTimeSlots());

        }
        return doctorRepository.save(doctor);
    }




    public AvailibilitySchedule saveAvailability(String doctorid, AvailibilitySchedule availibilityScheduledto){

        Doctor doc = doctorRepository.findById(doctorid)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorid));
        AvailibilitySchedule schedule = new AvailibilitySchedule();
        schedule.setDate(availibilityScheduledto.getDate());
        schedule.setDay(availibilityScheduledto.getDay());
        schedule.setAppointmentType(availibilityScheduledto.getAppointmentType());
        schedule.setDoctor(doc);
        return availabilityScheduleRepository.save(schedule);
    }

    public List<Doctor> getAllDoctor(){

        return doctorRepository.findAll();
    }


    public Doctor getDoctor(String doctorid){

        return doctorRepository.findById(doctorid).orElseThrow(() -> new RuntimeException("Doctor not found with id: " + doctorid));
    }


    public void removeDoctor(String doctorid){

         doctorRepository.deleteById(doctorid);
    }





}
