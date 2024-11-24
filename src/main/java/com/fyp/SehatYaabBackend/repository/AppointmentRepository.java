package com.fyp.SehatYaabBackend.repository;

import com.fyp.SehatYaabBackend.model.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByPatient(String patientId);
    List<Appointment> findByDoctor(String doctorId);

    Boolean existsByPatient(String patientId);
}
