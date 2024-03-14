package com.movie.expert.securitypolicies;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class SecurityConfig {
    @Value("${security.validity}")
    @Getter
    @Setter
    private long validity;

    @Value("${security.secret}")
    @Getter
    @Setter
    private String secret;

}