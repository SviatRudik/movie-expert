package com.movie.expert.services;

import com.movie.expert.clients.MovieApi;
import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieApi movieApi;

    @Override
    public ApiResponse<Movie> searchMovies(String name, Integer page) {
        return movieApi.searchMovies(name, page);
    }
}
