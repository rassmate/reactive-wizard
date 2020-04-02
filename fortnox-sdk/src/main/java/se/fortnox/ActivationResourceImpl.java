package se.fortnox;

import rx.Observable;
import rx.RxReactiveStreams;
import se.fortnox.authorization.AuthorizationResource;
import se.fortnox.companyinformation.CompanyInformationResource;

import javax.inject.Inject;

public class ActivationResourceImpl implements ActivationResource {

    private final AuthorizationResource      authorizationResource;
    private final CompanyInformationResource companyInformationResource;
    private final Customers                  customers;

    @Inject
    public ActivationResourceImpl(AuthorizationResource authorizationResource,
        CompanyInformationResource companyInformationResource,
        Customers customers) {
        this.authorizationResource = authorizationResource;
        this.companyInformationResource = companyInformationResource;
        this.customers = customers;
    }

    @Override
    public Observable<Boolean> activate(String authorizationCode) {
        return RxReactiveStreams.toObservable(authorizationResource.authorize(authorizationCode)
            .flatMap(authorizationResult -> {
                final String accessToken = authorizationResult.getAuthorization().getAccessToken();
                return companyInformationResource.getCompanyInformation(accessToken)
                        .map(companyInformationResult -> {
                            customers.register(companyInformationResult.getCompanyInformation().getDatabaseNumber(), accessToken);
                            return true;
                        });
                }
            ));
    }
}
