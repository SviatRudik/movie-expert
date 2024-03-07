package com.movie.expert.daos;

import com.movie.expert.models.User;
import com.movie.expert.models.UserDTO;

import java.util.Optional;

public interface UserDAO {
    Optional<UserDTO> loadUserByUsername(String username);
    Optional<UserDTO> loadUserByEmail(String email);

    void register(User user);
}
