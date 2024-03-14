package com.movie.expert.daos;

import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;

import java.util.List;

public interface ReviewDAO {
    void addReview(ReviewRequest req, long userId, long movieId);
    List<Review> getReviews(Integer page);
    Integer getTotalReviewPageCount();
    List<Review> getReviewsOnSubscription(long userId, Integer page);
    Integer getTotalReviewOnSubscriptionPageCount(long userId);
}
