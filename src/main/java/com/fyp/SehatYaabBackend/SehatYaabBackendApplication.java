package com.fyp.SehatYaabBackend;

import com.fyp.SehatYaabBackend.model.AvailibilitySchedule;
import com.fyp.SehatYaabBackend.model.Doctor;
import com.fyp.SehatYaabBackend.model.Patient;
import com.fyp.SehatYaabBackend.model.TimeSlots;
import com.fyp.SehatYaabBackend.repository.DoctorRepository;
import com.fyp.SehatYaabBackend.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SehatYaabBackendApplication {



	public static void main(String[] args) {
	  ApplicationContext context =  SpringApplication.run(SehatYaabBackendApplication.class, args);



	}

}
