package com.fyp.SehatYaabBackend.controllers;

import com.fyp.SehatYaabBackend.dto.ReviewRequestDTO;
import com.fyp.SehatYaabBackend.model.Reviews;
import com.fyp.SehatYaabBackend.service.impl.ReviewServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {

    private ReviewServiceImpl reviewService;

    public ReviewsController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }


    @PostMapping("apis/saveReview")
    ResponseEntity<Reviews> saveReview(@RequestBody ReviewRequestDTO request){

        return new ResponseEntity<>(reviewService.saveReviews(request),HttpStatus.CREATED);

    }

}
