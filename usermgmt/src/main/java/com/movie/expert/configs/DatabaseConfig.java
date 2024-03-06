package com.movie.expert.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
    @Value("${database.url}")
    @Getter
    @Setter
    private String url;

    @Value("${database.password}")
    @Getter
    @Setter
    private String password;

    @Value("${database.user}")
    @Getter
    @Setter
    private String user;
}
