package com.movie.expert.daos;

import com.movie.expert.models.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> loadUserByUsername(String username);
    Optional<User> loadUserByEmail(String email);

    void register(User user);
}
