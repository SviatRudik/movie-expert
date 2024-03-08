package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    @Getter
    @Setter
    private List<T> results;
    @Getter
    @Setter
    private Integer page;
    @Getter
    @Setter
    private Integer totalPages;
}
