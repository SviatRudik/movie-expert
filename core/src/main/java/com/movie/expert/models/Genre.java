package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Genre {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Integer id;

    public Genre(String name) {
        this.name = name;
    }

}
