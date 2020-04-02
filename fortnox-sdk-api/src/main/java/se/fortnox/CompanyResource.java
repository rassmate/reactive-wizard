package se.fortnox;

import rx.Observable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/company")
public interface CompanyResource {

    @GET
    Observable<CompanyInformation> getCompanyInformation();
}
