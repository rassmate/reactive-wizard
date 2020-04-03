package se.fortnox;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import se.fortnox.authorization.Authorization;
import se.fortnox.authorization.AuthorizationResource;
import se.fortnox.authorization.AuthorizationResult;
import se.fortnox.companyinformation.CompanyInformationResource;
import se.fortnox.companyinformation.CompanyInformationResult;
import se.fortnox.companyinformation.CompanyInformation;
import se.fortnox.impl.ActivationResourceImpl;
import se.fortnox.reactivewizard.jaxrs.WebException;

import java.util.UUID;

import static io.netty.handler.codec.http.HttpResponseStatus.UNAUTHORIZED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static reactor.core.publisher.Mono.just;

public class ActivationResourceImplTest {

    @Mock
    AuthorizationResource authorizationResource;

    @Mock
    CompanyInformationResource companyInformationResource;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void activationEndPointShouldRetrieveAccessTokenAndAddCustomerToDb() {

        //Given
        String              accessToken         = UUID.randomUUID().toString();
        AuthorizationResult authorizationResult = getAuthorizationResult(accessToken);
        when(authorizationResource.authorize(anyString())).thenReturn(just(authorizationResult));

        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setDatabaseNumber("12345");
        when(companyInformationResource.getCompanyInformation(anyString()))
            .thenReturn(just(new CompanyInformationResult(companyInformation)));
        Customers              customers          = new Customers();
        ActivationResourceImpl activationResource = new ActivationResourceImpl(authorizationResource,companyInformationResource,customers);

        //When
        Boolean registered = activationResource.activate(UUID.randomUUID().toString()).toBlocking().singleOrDefault(null);

        //Then
        assertThat(registered).isEqualTo(true);
        assertThat(customers.getAccessToken("12345").block()).isEqualTo(accessToken);
    }

    @Test
    public void activatingEndpointShouldNotRegisterCustomerIfNotAuthorized() {

        //Given
        when(authorizationResource.authorize(anyString())).thenReturn(Mono.error(new WebException(UNAUTHORIZED)));

        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setDatabaseNumber("12345");
        when(companyInformationResource.getCompanyInformation(anyString()))
            .thenReturn(just(new CompanyInformationResult(companyInformation)));
        Customers              customers          = new Customers();
        ActivationResourceImpl activationResource = new ActivationResourceImpl(authorizationResource,companyInformationResource,customers);

        assertThatExceptionOfType(WebException.class)
            .isThrownBy(() -> {
                activationResource.activate(UUID.randomUUID().toString()).toBlocking().singleOrDefault(null);
            });

        assertThatExceptionOfType(WebException.class)
            .isThrownBy(() -> {
                customers.getAccessToken("12345").block();
            });
    }

    @Test
    public void activatingEndpointShouldNotRegisterCustomerIfCompanyEndpointFails() {

        //Given
        when(authorizationResource.authorize(anyString())).thenReturn(Mono.error(new WebException(UNAUTHORIZED)));

        CompanyInformation companyInformation = new CompanyInformation();
        companyInformation.setDatabaseNumber("12345");
        when(companyInformationResource.getCompanyInformation(anyString()))
            .thenReturn(just(new CompanyInformationResult(companyInformation)));
        Customers              customers          = new Customers();
        ActivationResourceImpl activationResource = new ActivationResourceImpl(authorizationResource,companyInformationResource,customers);

        assertThatExceptionOfType(WebException.class)
            .isThrownBy(() -> {
                activationResource.activate(UUID.randomUUID().toString()).toBlocking().singleOrDefault(null);
            });

        assertThatExceptionOfType(WebException.class)
            .isThrownBy(() -> {
                customers.getAccessToken("12345").block();
            });
    }

    private AuthorizationResult getAuthorizationResult(String accessToken) {
        AuthorizationResult authorizationResult = new AuthorizationResult();
        Authorization       authorization       = new Authorization();
        authorization.setAccessToken(accessToken);
        authorizationResult.setAuthorization(authorization);
        return authorizationResult;
    }
}
