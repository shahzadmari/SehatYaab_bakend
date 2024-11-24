package com.fyp.SehatYaabBackend.service.impl;


import com.fyp.SehatYaabBackend.dto.ReviewRequestDTO;
import com.fyp.SehatYaabBackend.model.Doctor;
import com.fyp.SehatYaabBackend.model.Reviews;
import com.fyp.SehatYaabBackend.repository.DoctorRepository;
import com.fyp.SehatYaabBackend.repository.ReviewsRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl {

    private ReviewsRepository repository;

    private DoctorRepository doctorRepository;

    public ReviewServiceImpl(ReviewsRepository repository, DoctorRepository doctorRepository) {
        this.repository = repository;
        this.doctorRepository = doctorRepository;
    }


    public Reviews saveReviews(ReviewRequestDTO request){

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));


        Reviews reviews = new Reviews();
        reviews.setRating(request.getRating());
        reviews.setPatientName(request.getPatientName());
        reviews.setPatienEmail(request.getPatienEmail());
        reviews.setComment(request.getComment());
        reviews.setDoctor(doctor);
        doctor.getReviews().add(reviews);

        return repository.save(reviews);
    }
}
