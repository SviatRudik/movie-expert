package com.movie.expert.daos;

import com.movie.expert.models.User;

import java.util.Optional;

public interface AuthDAO {
    Optional<User> loadUserByUsername(String username);
}
