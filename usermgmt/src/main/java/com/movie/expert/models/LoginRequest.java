package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
}
