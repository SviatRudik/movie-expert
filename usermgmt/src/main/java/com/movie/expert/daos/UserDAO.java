package com.movie.expert.daos;

import com.movie.expert.models.User;
import com.movie.expert.models.UserInfo;

import java.util.Optional;

public interface UserDAO {
    Optional<UserInfo> loadUserByUsername(String username);
    Optional<UserInfo> loadUserByEmail(String email);

    void register(User user);
}
