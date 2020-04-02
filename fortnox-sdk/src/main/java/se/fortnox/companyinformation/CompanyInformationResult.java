package se.fortnox.companyinformation;

import com.fasterxml.jackson.annotation.JsonProperty;
import se.fortnox.CompanyInformation;

public class CompanyInformationResult {
    @JsonProperty("CompanyInformation")
    private CompanyInformation companyInformation;

    public CompanyInformationResult() {
    }

    public CompanyInformationResult(CompanyInformation companyInformation) {
        this.companyInformation = companyInformation;
    }

    public CompanyInformation getCompanyInformation() {
        return companyInformation;
    }

    public void setCompanyInformation(CompanyInformation companyInformation) {
        this.companyInformation = companyInformation;
    }
}
