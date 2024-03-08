package com.movie.expert.controllers;

import com.movie.expert.models.Movie;
import com.movie.expert.services.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    ResponseEntity<List<Movie>> searchMovies(HttpServletRequest request) {
        String encName = request.getParameter("name");
        List<Movie> response = movieService.searchMovies(encName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
