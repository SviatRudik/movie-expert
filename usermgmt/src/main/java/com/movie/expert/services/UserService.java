package com.movie.expert.services;

import com.movie.expert.models.RegistrationRequest;
import com.movie.expert.models.RegistrationResponse;
import com.movie.expert.models.UserDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    RegistrationResponse register(RegistrationRequest request);

    UserDTO loadUserByUsername(String username) throws UsernameNotFoundException;
}
