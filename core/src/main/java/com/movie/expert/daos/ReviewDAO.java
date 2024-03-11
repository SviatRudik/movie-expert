package com.movie.expert.daos;

import com.movie.expert.models.ReviewRequest;

public interface ReviewDAO {
    void addReview(ReviewRequest req, Integer userId);
}
