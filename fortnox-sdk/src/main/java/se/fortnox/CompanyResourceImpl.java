package se.fortnox;

import rx.Observable;
import rx.RxReactiveStreams;
import se.fortnox.auth.FortnoxConfig;
import se.fortnox.companyinformation.CompanyInformationResource;
import se.fortnox.companyinformation.CompanyInformationResult;
import se.fortnox.vouchers.VouchersResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CompanyResourceImpl implements CompanyResource {

    private final CompanyInformationResource companyInformationResource;
    private Customers customers;
    private FortnoxConfig fortnoxConfig;

    @Inject
    public CompanyResourceImpl(
        CompanyInformationResource companyInformationResource,
        Customers customers,
        FortnoxConfig fortnoxConfig) {
        this.companyInformationResource = companyInformationResource;
        this.customers = customers;
        this.fortnoxConfig = fortnoxConfig;

        if (fortnoxConfig.getDefaultCustomer() != null &&
            fortnoxConfig.getDefaultCustomerAccessToken() != null) {
            customers.register(fortnoxConfig.getDefaultCustomer(), fortnoxConfig.getDefaultCustomerAccessToken());
        }
    }

    @Override
    public Observable<CompanyInformation> getCompanyInformation() {
        return RxReactiveStreams.toObservable(customers.getAccessToken(fortnoxConfig.getDefaultCustomer())
            .flatMap(companyInformationResource::getCompanyInformation)
            .map(CompanyInformationResult::getCompanyInformation));
    }
}
