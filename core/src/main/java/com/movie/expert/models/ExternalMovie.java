package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ExternalMovie {
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private Double voteAverage;
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
    private long id;
    @Getter
    @Setter
    private List<Genre> genres;

}
