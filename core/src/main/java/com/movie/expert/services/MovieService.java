package com.movie.expert.services;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Movie;

public interface MovieService {
    ApiResponse<Movie> searchMovies(String name, Integer page);

    Long getOrCreateMovieId(Long externalId);

    ApiResponse<Movie> getMoviesWithReviews(Integer page);
}
