package com.movie.expert.services;

import com.movie.expert.clients.MovieApi;
import com.movie.expert.daos.MovieDAO;
import com.movie.expert.models.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieApi movieApi;
    private final MovieDAO movieDAO;

    @Override
    public ApiResponse<Movie> searchMovies(String name, Integer page) {
        ApiResponse<ExternalMovie> apiResponse = movieApi.searchMovies(name, page);
        List<Movie> movies = apiResponse.getResults().stream().map(Movie::new).toList();

        return new ApiResponse<Movie>(movies, apiResponse.getPage(), apiResponse.getTotalPages());
    }

    @Override
    @Transactional
    public Long getOrCreateMovieId(Long externalId) {
        Optional<Movie> movie = movieDAO.findMovieByExternalId(externalId);
        Optional<Long> optId = movie.map(Movie::getId);

        return optId.orElseGet(() -> createMovie(externalId));
    }

    @Override
    @Transactional
    public ApiResponse<Movie> getMoviesWithReviews(Integer page) {
        List<Movie> reviews = movieDAO.getMovies(page);
        Integer pageAmount = movieDAO.getTotalMoviePageCount();

        return new ApiResponse<Movie>(reviews, page, pageAmount);
    }

    private Long createMovie(Long externalId) {
        ExternalMovie movie = movieApi.searchMoviesById(externalId);
        Long movieId = movieDAO.addMovie(movie);
        addNewGenres(movie.getGenres(), movieId);

        return movieId;
    }

    private void addNewGenres(List<Genre> genres, Long movieId) {
        List<String> genreNames = genres.stream().map(Genre::getName).toList();
        List<Genre> existingGenre = getGenres(genreNames);
        List<String> existingGenreNames = existingGenre.stream().map(Genre::getName).toList();
        List<Integer> genreIds = addGenres(genres, existingGenreNames);
        List<Integer> existingGenreIds = existingGenre.stream().map(Genre::getId).toList();
        genreIds.addAll(existingGenreIds);
        addGenreMovies(genreIds, movieId);
    }

    private List<Genre> getGenres(List<String> genreNames) {
        List<Genre> genres = new ArrayList<>();
        for (String genreName : genreNames) {
            movieDAO.findGenre(genreName).ifPresent(genres::add);
        }
        return genres;
    }

    private List<Integer> addGenres(List<Genre> genres, List<String> existingGenreNames) {
        List<Integer> newGenreIds = new ArrayList<>();
        for (Genre genre : genres) {
            if (!existingGenreNames.contains(genre.getName())) {
                Integer newGenreId = movieDAO.addGenre(genre);
                newGenreIds.add(newGenreId);
            }
        }
        return newGenreIds;
    }

    private void addGenreMovies(List<Integer> genreIds, Long movieId) {
        for (Integer genreId : genreIds) {
            movieDAO.addGenreMovie(movieId, genreId);
        }
    }

}
