package com.movie.expert.securitypolicies;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecuritySettings.class})
public class SecurityConfiguration {
}
