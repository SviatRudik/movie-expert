package com.movie.expert.daos;

import com.movie.expert.models.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@AllArgsConstructor
public class AuthDAOImpl implements AuthDAO {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public Optional<User> loadUserByUsername(String username) {
        String sql = "SELECT id, username, password, email," +
                "       account_non_expired, account_non_locked," +
                "       credentials_non_expired, enabled " +
                "FROM users " +
                "WHERE username = ?;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class), username).stream().findAny();
    }
}
