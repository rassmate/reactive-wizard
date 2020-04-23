package se.fortnox.authorization;

import reactor.core.publisher.Mono;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;

@Path("/3")
public interface AuthorizationResource {

    @GET
    Mono<AuthorizationResult> authorize(@HeaderParam("Authorization-Code") String authorizationCode);
}
