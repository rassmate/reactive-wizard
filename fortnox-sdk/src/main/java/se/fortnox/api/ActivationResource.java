package se.fortnox.api;

import rx.Observable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("api/activation")
public interface ActivationResource {

    @GET
    Observable<Boolean> activate(@QueryParam("authorization-code") String authorizationCode);
}
