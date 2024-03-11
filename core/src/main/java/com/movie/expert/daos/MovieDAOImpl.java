package com.movie.expert.daos;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MovieDAOImpl {
    private final JdbcTemplate jdbcTemplate;
}
