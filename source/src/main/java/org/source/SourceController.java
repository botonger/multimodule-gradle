package org.source;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SourceController {
    private final WebClient webClient;

    @GetMapping("hello")
    public Mono<String> hello() {
        return webClient
                .get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class);
    }

    @PostMapping("dxdev3")
    public <T> Mono<ResponseEntity<Response<T>>> hellodxdev3() {
        return webClient
                .post()
                .uri("/dxdev3")
                .retrieve()
                .toEntity(new ParameterizedTypeReference<Response<T>>() {});
    }
}
