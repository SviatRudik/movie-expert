package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private Double tmdbRating;
    @Getter
    @Setter
    private String posterPath;
    @Getter
    @Setter
    private String overview;
    @Getter
    @Setter
    private String releaseDate;
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private List<Genre> genres;
    @Getter
    @Setter
    private Long externalId;
    @Getter
    @Setter
    private Double rating;

    public Movie(ExternalMovie ext) {
        this.title = ext.getTitle();
        this.externalId = ext.getId();
        this.genres = ext.getGenres();
        this.tmdbRating = ext.getVoteAverage();
        this.posterPath = ext.getPosterPath();
        this.overview = ext.getOverview();
        this.releaseDate = ext.getReleaseDate();
    }

}
