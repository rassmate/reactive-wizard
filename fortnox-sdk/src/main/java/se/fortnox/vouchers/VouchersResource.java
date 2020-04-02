package se.fortnox.vouchers;

import reactor.core.publisher.Mono;
import rx.Observable;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/3/vouchers")
public interface VouchersResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Mono<VoucherResult> getAll(@HeaderParam("Access-Token") String accessToken, @BeanParam VoucherFilter voucherFilter);
}
