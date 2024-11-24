package com.fyp.SehatYaabBackend.service.impl;


import com.fyp.SehatYaabBackend.model.Appointment;
import com.fyp.SehatYaabBackend.model.Patient;
import com.fyp.SehatYaabBackend.repository.AppointmentRepository;
import com.fyp.SehatYaabBackend.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl {

    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;


    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }




    public Patient save(Patient patient){

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){

        return patientRepository.findAll();
    }


    public void deletePatient(String id){

        if (appointmentRepository.existsByPatient(id)){

            List<Appointment> appointment = appointmentRepository.findByPatient(id);
        }

    }
}
