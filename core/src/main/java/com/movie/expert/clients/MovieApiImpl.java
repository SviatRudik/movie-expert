package com.movie.expert.clients;

import com.movie.expert.configs.ClientConfig;
import com.movie.expert.models.ApiResponse;
import com.movie.expert.models.ExternalMovie;
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
    public ApiResponse<ExternalMovie> searchMovies(String name, Integer page) {
        String encName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        return client().get()
                .uri("/search/movie?query=" + encName + "&include_adult=true&language=en-US&page=" + page)
                .retrieve().bodyToMono(new ParameterizedTypeReference<ApiResponse<ExternalMovie>>() {
                }).block();
    }

    @Override
    public ExternalMovie searchMoviesById(long movieId) {
        return client().get()
                .uri("/movie/" + movieId + "?language=en-US")
                .retrieve().bodyToMono(new ParameterizedTypeReference<ExternalMovie>() {
                }).block();
    }
}
