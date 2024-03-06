package com.movie.expert.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Getter
    @Setter
    @NotNull
    @Size(min = 2, max = 30)
    private String username;
    @Getter
    @Setter
    @NotNull
    @Size(min = 6, max = 30)
    private String password;
    @Getter
    @Setter
    @NotNull
    @Email
    private String email;

}
