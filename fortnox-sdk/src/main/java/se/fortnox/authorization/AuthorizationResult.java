package se.fortnox.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorizationResult {
    @JsonProperty("Authorization")
    private Authorization authorization;

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
