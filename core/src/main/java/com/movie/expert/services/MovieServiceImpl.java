package com.movie.expert.services;

import com.movie.expert.clients.MovieApi;
import com.movie.expert.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{
    private final MovieApi movieApi;

    @Override
    public List<Movie> searchMovies(String encName){
        return movieApi.searchMovies(encName);
    }
}
