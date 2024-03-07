package com.movie.expert.services;

import com.movie.expert.daos.AuthDAO;
import com.movie.expert.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AuthDAO authDAO;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = authDAO.loadUserByUsername(username);
        UsernameNotFoundException ex = new UsernameNotFoundException("User is not found for username: " + username);
        return optUser.orElseThrow(() -> ex);
    }
}
