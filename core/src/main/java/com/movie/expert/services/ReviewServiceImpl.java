package com.movie.expert.services;

import com.movie.expert.daos.ReviewDAO;
import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final MovieService movieService;
    private final ReviewDAO reviewDAO;

    @Override
    @Transactional
    public void createReview(ReviewRequest request, Long userId) {
        Long movieId = movieService.getOrCreateMovieId(request.getExternalMovieId());

        reviewDAO.addReview(request, userId, movieId);
    }

    @Override
    @Transactional
    public ApiResponse<Review> getReviews(Integer page) {
        List<Review> reviews = reviewDAO.getReviews(page);
        Integer pageAmount = reviewDAO.getTotalReviewPageCount();

        return new ApiResponse<Review>(reviews, page, pageAmount);
    }

    @Override
    @Transactional
    public ApiResponse<Review> getReviewsOnSubscription(Long userId, Integer page) {
        List<Review> reviews = reviewDAO.getReviewsOnSubscription(userId, page);
        Integer pageAmount = reviewDAO.getTotalReviewOnSubscriptionPageCount(userId);

        return new ApiResponse<Review>(reviews, page, pageAmount);
    }
}
