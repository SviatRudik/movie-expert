package com.movie.expert.services;

import com.movie.expert.models.ReviewRequest;

public interface ReviewService {
    void createReview(ReviewRequest request);
}
