package com.movie.expert.services;

import com.movie.expert.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> searchMovies(String encName);
}
