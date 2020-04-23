package se.fortnox;

import reactor.core.publisher.Mono;

public interface CustomerRepository {
    Mono<String> getAccessToken(String customer);

    Mono<String> register(String customer, String accessToken);
}
