package com.movie.expert.services;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;

public interface ReviewService {
    void createReview(ReviewRequest request, Long userId);

    ApiResponse<Review> getReviews(Integer page);

    ApiResponse<Review> getReviewsOnSubscription(Long userId, Integer page);
}
