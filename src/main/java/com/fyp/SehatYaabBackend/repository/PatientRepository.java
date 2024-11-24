package com.fyp.SehatYaabBackend.repository;

import com.fyp.SehatYaabBackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,String> {


}
