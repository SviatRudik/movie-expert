package com.movie.expert.configs;

import com.movie.expert.securitypolicies.SecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.movie.expert")
@Import({DatabaseConfig.class, DispatcherServ.class, SpringConfig.class, SecurityConfig.class})
public class MainConfig {
}
