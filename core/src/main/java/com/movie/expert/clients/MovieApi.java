package com.movie.expert.clients;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.ExternalMovie;


public interface MovieApi {
    ApiResponse<ExternalMovie> searchMovies(String name, Integer page);

    ExternalMovie searchMoviesById(Long movieId);
}
