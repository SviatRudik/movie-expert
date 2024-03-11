package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private Integer rating;
    @Getter
    @Setter
    private String content;
}
