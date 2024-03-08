package com.movie.expert.clients;

import com.movie.expert.configs.ClientConfig;
import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class MovieApiImpl implements MovieApi {
    private final ClientConfig config;
    private final ClientBuilder clientBuilder;

    private WebClient client() {
        return clientBuilder.webClientBuilder()
                .baseUrl(config.getUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + config.getToken())
                .build();
    }

    @Override
    public ApiResponse<Movie> searchMovies(String name, Integer page) {
        String encName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        return client().get()
                .uri("/search/movie?query=" + encName + "&include_adult=true&language=en-US&page=" + page)
                .retrieve().bodyToMono(new ParameterizedTypeReference<ApiResponse<Movie>>() {
                }).block();
    }

}
