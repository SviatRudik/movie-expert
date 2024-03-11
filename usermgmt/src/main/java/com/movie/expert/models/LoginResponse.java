package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String token;

}
