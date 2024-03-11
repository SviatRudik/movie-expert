package com.movie.expert.daos;

import com.movie.expert.models.User;
import lombok.AllArgsConstructor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void register(User user) {
        String sql =
                "INSERT INTO users (username, password,email, account_non_expired, account_non_locked, credentials_non_expired, enabled) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), true, true, true, true);
    }

    public boolean checkUserExistsByEmail(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, email);
        return count > 0;
    }

    public boolean checkUserExistsByUsername(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        int count = jdbcTemplate.queryForObject(query, Integer.class, username);
        return count > 0;
    }

}
