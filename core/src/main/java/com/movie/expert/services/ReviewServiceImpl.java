package com.movie.expert.services;

import com.movie.expert.clients.MovieApi;
import com.movie.expert.daos.ReviewDAO;
import com.movie.expert.models.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements  ReviewService{
    private final MovieApi movieApi;
    private final ReviewDAO reviewDAO;

    @Override
    public void createReview(ReviewRequest request) {

    }
}
