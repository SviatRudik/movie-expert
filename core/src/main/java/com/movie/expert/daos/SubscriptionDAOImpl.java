package com.movie.expert.daos;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SubscriptionDAOImpl implements SubscriptionDAO {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void subscribe(Long userId, Long subscribedUserId) {
        String sql =
                "INSERT INTO subscriptions (user_id, subscribed_user_id) " +
                        "VALUES (?, ?)";
        jdbcTemplate.update(sql, userId, subscribedUserId);
    }
}
