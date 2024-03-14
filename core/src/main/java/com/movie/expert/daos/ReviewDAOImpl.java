package com.movie.expert.daos;

import com.movie.expert.models.Review;
import com.movie.expert.models.ReviewRequest;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class ReviewDAOImpl implements ReviewDAO {
    private final JdbcTemplate jdbcTemplate;
    private final Integer DEFAULT_PAGE_SIZE = 10;

    @Override
    public void addReview(ReviewRequest req, Long userId, Long movieId) {
        String sql =
                "INSERT INTO reviews (user_id, movie_id, title, rating, content, created_at) " +
                        "VALUES (?, ?, ?, ?,?, ?)";
        jdbcTemplate.update(sql, userId, movieId, req.getTitle(), req.getRating(), req.getContent(), LocalDateTime.now());
    }

    @Override
    public List<Review> getReviews(Integer page) {
        Integer offset = (page - 1) * DEFAULT_PAGE_SIZE;
        String sql = "SELECT * FROM reviews ORDER BY created_at DESC LIMIT ? OFFSET ? ";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Review.class), DEFAULT_PAGE_SIZE, offset);
    }

    @Override
    public Integer getTotalReviewPageCount() {
        String sql = "SELECT COUNT(*) FROM reviews";
        Integer amountOfReviews = jdbcTemplate.queryForObject(sql, Integer.class);

        return amountOfReviews / DEFAULT_PAGE_SIZE;
    }

    @Override
    public List<Review> getReviewsOnSubscription(Long userId, Integer page) {
        Integer offset = (page - 1) * DEFAULT_PAGE_SIZE;
        String sql = "SELECT r.* " +
                "FROM reviews r " +
                "JOIN subscriptions s ON r.user_id = s.user_id " +
                "WHERE s.subscribed_user_id = ?  " +
                "ORDER BY r.created_at DESC " +
                "LIMIT ? OFFSET ?";

        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Review.class), userId, DEFAULT_PAGE_SIZE, offset);
    }

    @Override
    public Integer getTotalReviewOnSubscriptionPageCount(Long userId) {
        String sql = "SELECT COUNT(*) " +
                "FROM reviews r " +
                "JOIN subscriptions s ON r.user_id = s.subscribed_user_id " +
                "WHERE s.user_id = ?  ";
        Integer amountOfReviews = jdbcTemplate.queryForObject(sql, Integer.class, userId);

        return amountOfReviews / DEFAULT_PAGE_SIZE;
    }
}
