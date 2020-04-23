package se.fortnox.vouchers;

import reactor.core.publisher.Mono;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/3/vouchers")
public interface VouchersResource {

    @GET
    Mono<VoucherResult> getAll(@HeaderParam("Access-Token") String accessToken, @BeanParam VoucherFilter voucherFilter);

    @GET
    @Path("sublist/{voucherserie}")
    Mono<VoucherResult> getByVoucherSeries(@HeaderParam("Access-Token") String accessToken, @PathParam("voucherserie") String voucherSerie);

    @GET
    @Path("{voucherserie}/{vouchernumber}")
    Mono<SingleVoucher> getVoucher(@HeaderParam("Access-Token") String accessToken,
        @PathParam("voucherserie") String voucherSerie,
        @PathParam("vouchernumber") Long voucherNumber,
        @QueryParam("financialyear") Integer year
    );
}
