package com.movie.expert.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String username;
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

}
