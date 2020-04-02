package se.fortnox.auth;

import se.fortnox.reactivewizard.client.PreRequestHook;
import se.fortnox.reactivewizard.client.RequestBuilder;

import javax.inject.Inject;

public class AuthenticatingPreRequestHook implements PreRequestHook {
    private static final String API_FORTNOX_SE = "api.fortnox.se";
    private static final String CLIENT_SECRET = "Client-Secret";
    private String clientSecret;

    @Inject
    public AuthenticatingPreRequestHook(FortnoxConfig fortnoxConfig) {
        this.clientSecret = fortnoxConfig.getClientSecret();
    }

    @Override
    public void apply(RequestBuilder request) {
        if (request.getFullUrl().contains(API_FORTNOX_SE)) {
            request.addHeader(CLIENT_SECRET, this.clientSecret);
        }
    }
}
