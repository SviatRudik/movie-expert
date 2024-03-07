package com.movie.expert.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@NoArgsConstructor
public class User implements UserDetails {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private List<Authority> authorities;
    @Getter
    @Setter
    private boolean accountNonExpired;
    @Getter
    @Setter
    private boolean accountNonLocked;
    @Getter
    @Setter
    private boolean credentialsNonExpired;
    @Getter
    @Setter
    private boolean enabled;


    public User(Long id, String username, String password, String email, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }
}
