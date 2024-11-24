package com.fyp.SehatYaabBackend.service.impl;


import com.fyp.SehatYaabBackend.dto.AppointmentRequest;
import com.fyp.SehatYaabBackend.dto.AppointmentResponseDTO;
import com.fyp.SehatYaabBackend.model.Appointment;
import com.fyp.SehatYaabBackend.model.Doctor;
import com.fyp.SehatYaabBackend.model.Patient;
import com.fyp.SehatYaabBackend.model.TimeSlots;
import com.fyp.SehatYaabBackend.repository.AppointmentRepository;
import com.fyp.SehatYaabBackend.repository.DoctorRepository;
import com.fyp.SehatYaabBackend.repository.PatientRepository;
import com.fyp.SehatYaabBackend.repository.TimeSlotsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AppointmentServiceImpl {



    private AppointmentRepository appointmentRepository;

   private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;



    private TimeSlotsRepository timeSlotsRepository;
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, TimeSlotsRepository timeSlotsRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.timeSlotsRepository = timeSlotsRepository;
    }




    public Appointment bookAppointment(AppointmentRequest request){

        TimeSlots timeSlot = timeSlotsRepository.findById(request.getTimeSlotId())
                .orElseThrow(() -> new RuntimeException("TimeSlot not found"));

        // Mark the time slot as booked
        timeSlot.setBooked(true
        );
        timeSlotsRepository.save(timeSlot);



        // Create and save a new appointment
        Appointment appointment = new Appointment();
        appointment.setDoctor(request.getDoctorId());
        appointment.setPatient(request.getPatientId());
        appointment.setAppointment_date(LocalDate.parse(request.getAppointmentDate()));
        appointment.setAppointment_status(request.getAppointmentStatus());
        appointment.setAppointment_day(request.getAppointmentDay());
        appointment.setAppointment_type(request.getAppointmentType());
        appointment.setTimeslot(timeSlot);


        return appointmentRepository.save(appointment);


    }


    @Transactional
    public void deleteAppointment(int appointmentId){

        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(()-> new RuntimeException("not found"));
        TimeSlots timeSlots = appointment.getTimeslot();
        timeSlots.setAppointment(null);
        timeSlots.setBooked(false);
        appointment.setTimeslot(null);
        timeSlotsRepository.save(timeSlots);
        appointment.setTimeslot(null);
        appointmentRepository.delete(appointment);
        System.out.println("success");

    }


    public List<AppointmentResponseDTO> getAppointmentsByPatientId(String patientId) {
        // Find all appointments for the patient
        List<Appointment> appointments = appointmentRepository.findByPatient(patientId);

        // Retrieve the patient entity to get the patient name
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Iterate over each appointment and convert to AppointmentDTO
        List<AppointmentResponseDTO> appointmentDTOs = new ArrayList<>();
        for (Appointment appointment : appointments) {
            // Retrieve the doctor and timeslot entities by their IDs
            Doctor doctor = doctorRepository.findById(appointment.getDoctor())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            TimeSlots timeSlot = timeSlotsRepository.findById(appointment.getTimeslot().getSlot_id())
                    .orElseThrow(() -> new RuntimeException("TimeSlot not found"));

            // Convert the appointment to AppointmentDTO and add to the list
            appointmentDTOs.add(new AppointmentResponseDTO(
                    appointment.getAppointmentid(),
                    patient.getName(),
                    doctor.getDoctor_name(),
                    timeSlot.getToken_no(),

                    appointment.getAppointment_date().toString(),
                    appointment.getAppointment_day(),
                    appointment.getAppointment_type()
            ));
        }

        return appointmentDTOs;
    }


      public List<Appointment> getAllAppointments(){

        return appointmentRepository.findAll();

      }

    public List<AppointmentResponseDTO> getAppointmentsByDoctorId(String doctorId) {
        // Find all appointments for the patient
        List<Appointment> appointments = appointmentRepository.findByDoctor(doctorId);

        // Retrieve the patient entity to get the patient name
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("doctor not found"));

        // Iterate over each appointment and convert to AppointmentDTO
        List<AppointmentResponseDTO> appointmentDTOs = new ArrayList<>();
        for (Appointment appointment : appointments) {
            // Retrieve the doctor and timeslot entities by their IDs
            Patient patient = patientRepository.findById(appointment.getPatient())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            TimeSlots timeSlot = timeSlotsRepository.findById(appointment.getTimeslot().getSlot_id())
                    .orElseThrow(() -> new RuntimeException("TimeSlot not found"));

            // Convert the appointment to AppointmentDTO and add to the list
            appointmentDTOs.add(new AppointmentResponseDTO(
                    appointment.getAppointmentid(),
                    patient.getName(),
                    doctor.getDoctor_name(),
                    timeSlot.getToken_no(),

                    appointment.getAppointment_date().toString(),
                    appointment.getAppointment_day(),
                    appointment.getAppointment_type()
            ));
        }

        return appointmentDTOs;
    }










}


