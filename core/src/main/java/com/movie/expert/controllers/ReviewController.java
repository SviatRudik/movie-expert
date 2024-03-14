package com.movie.expert.controllers;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;
import com.movie.expert.securitypolicies.JwtUtil;
import com.movie.expert.services.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final JwtUtil jwtUtil;

    private final String DEFAULT_PAGE = "1";

    @PostMapping
    ResponseEntity createReview(@RequestBody ReviewRequest request, HttpServletRequest req) {
        Long userId = jwtUtil.getId(req);
        reviewService.createReview(request, userId);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<ApiResponse<Review>> getReviews(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page) {
        ApiResponse<Review> result = reviewService.getReviews(page);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/subscription")
    ResponseEntity<ApiResponse<Review>> getReviewsOnSubscription(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page, HttpServletRequest req) {
        Long userId = jwtUtil.getId(req);
        ApiResponse<Review> result = reviewService.getReviewsOnSubscription(userId, page);

        return ResponseEntity.ok(result);
    }
}
