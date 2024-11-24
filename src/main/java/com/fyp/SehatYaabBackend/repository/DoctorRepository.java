package com.fyp.SehatYaabBackend.repository;

import com.fyp.SehatYaabBackend.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}
