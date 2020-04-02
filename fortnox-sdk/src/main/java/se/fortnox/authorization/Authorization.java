package se.fortnox.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Authorization {
    @JsonProperty("AccessToken")
    private String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
