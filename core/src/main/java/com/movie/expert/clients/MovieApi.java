package com.movie.expert.clients;

import com.movie.expert.models.Movie;

import java.util.List;

public interface MovieApi {
    List<Movie> searchMovies(String encName);
}
