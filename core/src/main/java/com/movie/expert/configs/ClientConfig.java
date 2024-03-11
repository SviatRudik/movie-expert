package com.movie.expert.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:client.properties")
public class ClientConfig {
    @Setter
    @Getter
    @Value("${api.url}")
    private String url;
    @Setter
    @Getter
    @Value("${api.token}")
    private String token;
}
