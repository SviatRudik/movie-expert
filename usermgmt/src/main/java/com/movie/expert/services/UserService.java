package com.movie.expert.services;

import com.movie.expert.models.RegistrationRequest;
import com.movie.expert.models.RegistrationResponse;

public interface UserService {
    RegistrationResponse register(RegistrationRequest request);

}
