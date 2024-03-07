package com.movie.expert.daos;

import com.movie.expert.models.User;
import com.movie.expert.models.UserDTO;
import lombok.AllArgsConstructor;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@AllArgsConstructor
public class UserDAOImpl implements UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<UserDTO> loadUserByUsername(String username) {
        String sql = "SELECT  username, email," +
                "       account_non_expired, account_non_locked," +
                "       credentials_non_expired, enabled " +
                "FROM users " +
                "WHERE username = ?;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserDTO.class), username).stream().findAny();
    }

    @Override
    public Optional<UserDTO> loadUserByEmail(String email) {
        String sql = "SELECT  username, email," +
                "       account_non_expired, account_non_locked," +
                "       credentials_non_expired, enabled " +
                "FROM users " +
                "WHERE email = ?;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserDTO.class), email).stream().findAny();
    }

    @Override
    public void register(User user) {
        String sql =
                "INSERT INTO users (username, password,email, account_non_expired, account_non_locked, credentials_non_expired, enabled) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), true, true, true, true);
    }
}
