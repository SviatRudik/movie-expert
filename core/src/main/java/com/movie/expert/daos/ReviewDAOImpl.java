package com.movie.expert.daos;

import com.movie.expert.models.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ReviewDAOImpl implements ReviewDAO{
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void addReview(ReviewRequest req, Integer userId) {
        String sql =
                "INSERT INTO reviews (user_id, title, rating, content) " +
                        "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, userId, req.getTitle(), req.getRating(), req.getContent());
    }
}
