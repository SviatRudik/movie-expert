package com.movie.expert.controllers;

import com.movie.expert.models.ReviewRequest;
import com.movie.expert.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;


    @PostMapping
    ResponseEntity createReview(@RequestBody ReviewRequest request) {
        reviewService.createReview(request);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
