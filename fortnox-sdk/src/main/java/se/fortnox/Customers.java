package se.fortnox;

import com.google.inject.Singleton;
import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;
import se.fortnox.reactivewizard.jaxrs.WebException;

import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class Customers implements CustomerRepository {
    private ConcurrentHashMap<String, String> registry = new ConcurrentHashMap<>();

    @Override
    public Mono<String> getAccessToken(String customer) {
        if (registry.containsKey(customer)) {
            return Mono.just(registry.get(customer));
        }
        return Mono.error(new WebException(HttpResponseStatus.UNAUTHORIZED));
    }

    @Override
    public Mono<String> register(String customer, String accessToken) {
        registry.put(customer, accessToken);
        return Mono.just(customer);
    }
}
