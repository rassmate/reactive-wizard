package se.fortnox;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompanyInformation {
    @JsonProperty("Address")
    private String address;

    @JsonProperty("City")
    private String city;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("DatabaseNumber")
    private String databaseNumber;

    @JsonProperty("CompanyName")
    private String companyName;

    @JsonProperty("OrganisationNumber")
    private String organizationNumber;

    @JsonProperty("VisitAddress")
    private String visitAddress;

    @JsonProperty("VisitCity")
    private String visitCity;

    @JsonProperty("VisitCountryCode")
    private String visitCountryCode;

    @JsonProperty("VisitZipCode")
    private String visitZipCode;

    @JsonProperty("ZipCode")
    private String zipCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDatabaseNumber() {
        return databaseNumber;
    }

    public void setDatabaseNumber(String databaseNumber) {
        this.databaseNumber = databaseNumber;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getVisitAddress() {
        return visitAddress;
    }

    public void setVisitAddress(String visitAddress) {
        this.visitAddress = visitAddress;
    }

    public String getVisitCity() {
        return visitCity;
    }

    public void setVisitCity(String visitCity) {
        this.visitCity = visitCity;
    }

    public String getVisitCountryCode() {
        return visitCountryCode;
    }

    public void setVisitCountryCode(String visitCountryCode) {
        this.visitCountryCode = visitCountryCode;
    }

    public String getVisitZipCode() {
        return visitZipCode;
    }

    public void setVisitZipCode(String visitZipCode) {
        this.visitZipCode = visitZipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
