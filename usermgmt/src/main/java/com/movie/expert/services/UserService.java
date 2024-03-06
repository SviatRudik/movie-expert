package com.movie.expert.services;

import com.movie.expert.models.RegistrationRequest;
import com.movie.expert.models.RegistrationResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    RegistrationResponse register(RegistrationRequest request);
}
