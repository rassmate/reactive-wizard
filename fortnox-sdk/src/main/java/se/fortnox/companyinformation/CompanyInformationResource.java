package se.fortnox.companyinformation;

import reactor.core.publisher.Mono;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/3/companyinformation")
public interface CompanyInformationResource {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Mono<CompanyInformationResult> getCompanyInformation(@HeaderParam("Access-Token") String accessToken);
}
