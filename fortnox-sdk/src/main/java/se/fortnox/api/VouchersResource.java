package se.fortnox.api;

import rx.Observable;
import se.fortnox.vouchers.SingleVoucher;
import se.fortnox.vouchers.VoucherResult;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("api/vouchers")
public interface VouchersResource {

    @GET
    Observable<VoucherResult> getVouchers(@QueryParam("customer") String customer);

    @GET
    @Path("{voucherseries}")
    Observable<VoucherResult> getVouchersBySerie(@QueryParam("customer") String customer, @PathParam("voucherseries") String voucherSeries);

    @GET
    @Path("{voucherseries}/{voucherNumber}")
    Observable<SingleVoucher> getVoucher(@QueryParam("customer") String customer,
        @PathParam("voucherseries") String voucherSeries,
        @PathParam("voucherNumber") Long voucherNumber,
        @QueryParam("year") Integer year
    );
}
