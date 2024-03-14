package com.movie.expert.daos;

import com.movie.expert.models.Genre;
import com.movie.expert.models.ExternalMovie;
import com.movie.expert.models.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieDAO {
    long addMovie(ExternalMovie movie);
    Integer addGenre(Genre genre);
    void addGenreMovie(long movieId, Integer genreId);
    Optional<Genre> findGenre(String genreName);
    Optional<Movie> findMovieByExternalId(long externalId);

    List<Movie> getMovies(Integer page);
    Integer getTotalMoviePageCount();

}
