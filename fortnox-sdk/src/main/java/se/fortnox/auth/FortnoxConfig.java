package se.fortnox.auth;

import se.fortnox.reactivewizard.config.Config;

@Config("fortnox")
public class FortnoxConfig {
    private String clientSecret;
    private String defaultCustomer;
    private String defaultCustomerAccessToken;

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getDefaultCustomer() {
        return defaultCustomer;
    }

    public void setDefaultCustomer(String defaultCustomer) {
        this.defaultCustomer = defaultCustomer;
    }

    public String getDefaultCustomerAccessToken() {
        return defaultCustomerAccessToken;
    }

    public void setDefaultCustomerAccessToken(String defaultCustomerAccessToken) {
        this.defaultCustomerAccessToken = defaultCustomerAccessToken;
    }
}
