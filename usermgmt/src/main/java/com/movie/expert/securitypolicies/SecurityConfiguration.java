package com.movie.expert.securitypolicies;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfig.class})
public class SecurityConfiguration {
}