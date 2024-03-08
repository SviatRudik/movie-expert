package com.movie.expert.clients;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Movie;


public interface MovieApi {
    ApiResponse<Movie> searchMovies(String name, Integer page);
}
