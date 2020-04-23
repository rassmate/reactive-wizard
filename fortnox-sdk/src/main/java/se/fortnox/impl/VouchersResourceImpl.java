package se.fortnox.impl;

import rx.Observable;
import rx.RxReactiveStreams;
import se.fortnox.CustomerRepository;
import se.fortnox.api.VouchersResource;
import se.fortnox.vouchers.SingleVoucher;
import se.fortnox.vouchers.VoucherFilter;
import se.fortnox.vouchers.VoucherResult;

import javax.inject.Inject;

public class VouchersResourceImpl implements VouchersResource {

    private final se.fortnox.vouchers.VouchersResource vouchersResource;
    private       CustomerRepository                   customerRepository;

    @Inject
    public VouchersResourceImpl(se.fortnox.vouchers.VouchersResource vouchersResource,
        CustomerRepository customerRepository) {
        this.vouchersResource = vouchersResource;
        this.customerRepository = customerRepository;
    }

    @Override
    public Observable<VoucherResult> getVouchers(String customer) {
        VoucherFilter voucherFilter = new VoucherFilter();
        return RxReactiveStreams.toObservable(customerRepository.getAccessToken(customer)
            .flatMap(accessToken -> vouchersResource.getAll(accessToken, voucherFilter)));
    }

    @Override
    public Observable<VoucherResult> getVouchersBySerie(String customer, String voucherSeries) {
        return RxReactiveStreams.toObservable(customerRepository.getAccessToken(customer)
            .flatMap(accessToken -> vouchersResource.getByVoucherSeries(accessToken, voucherSeries)));
    }

    @Override
    public Observable<SingleVoucher> getVoucher(String customer, String voucherSeries, Long voucherNumber, Integer year) {
        return RxReactiveStreams.toObservable(customerRepository.getAccessToken(customer)
            .flatMap(accessToken -> vouchersResource.getVoucher(accessToken, voucherSeries, voucherNumber, year)));
    }
}
