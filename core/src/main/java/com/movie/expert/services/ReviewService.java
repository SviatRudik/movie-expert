package com.movie.expert.services;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;

public interface ReviewService {
    void createReview(ReviewRequest request, long userId);

    ApiResponse<Review> getReviews(Integer page);

    ApiResponse<Review> getReviewsOnSubscription(long userId, Integer page);
}
