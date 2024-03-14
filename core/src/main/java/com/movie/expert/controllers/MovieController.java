package com.movie.expert.controllers;

import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Movie;
import com.movie.expert.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;
    private final String DEFAULT_PAGE = "1";

    @GetMapping
    ResponseEntity<ApiResponse<Movie>> searchMovies(@RequestParam("name") String name, @RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page) {
        ApiResponse<Movie> response = movieService.searchMovies(name, page);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/internal")
    ResponseEntity<ApiResponse<Movie>> getMoviesWithReviews(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE, required = false) Integer page) {
        ApiResponse<Movie> response = movieService.getMoviesWithReviews(page);

        return ResponseEntity.ok(response);
    }
}
