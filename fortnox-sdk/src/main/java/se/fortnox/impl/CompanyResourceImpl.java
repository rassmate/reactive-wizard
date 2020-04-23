package se.fortnox.impl;

import rx.Observable;
import rx.RxReactiveStreams;
import se.fortnox.CustomerRepository;
import se.fortnox.auth.FortnoxConfig;
import se.fortnox.companyinformation.CompanyInformationResource;
import se.fortnox.companyinformation.CompanyInformationResult;
import se.fortnox.companyinformation.CompanyInformation;
import se.fortnox.api.CompanyResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CompanyResourceImpl implements CompanyResource {

    private final CompanyInformationResource companyInformationResource;
    private       CustomerRepository         customerRepository;
    private       FortnoxConfig              fortnoxConfig;

    @Inject
    public CompanyResourceImpl(
        CompanyInformationResource companyInformationResource,
        CustomerRepository customerRepository,
        FortnoxConfig fortnoxConfig) {
        this.companyInformationResource = companyInformationResource;
        this.customerRepository = customerRepository;
        this.fortnoxConfig = fortnoxConfig;

        if (fortnoxConfig.getDefaultCustomer() != null &&
            fortnoxConfig.getDefaultCustomerAccessToken() != null) {
            customerRepository.register(fortnoxConfig.getDefaultCustomer(), fortnoxConfig.getDefaultCustomerAccessToken());
        }
    }

    @Override
    public Observable<CompanyInformation> getCompanyInformation(String customer) {
        String customerId = customer != null ? customer : fortnoxConfig.getDefaultCustomer();

        return RxReactiveStreams.toObservable(customerRepository.getAccessToken(customerId)
            .flatMap(companyInformationResource::getCompanyInformation)
            .map(CompanyInformationResult::getCompanyInformation));
    }
}
