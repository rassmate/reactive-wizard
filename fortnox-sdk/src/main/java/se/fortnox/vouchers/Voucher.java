package se.fortnox.vouchers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Voucher {
    @JsonProperty("VoucherSeries")
    private String voucherSeries;

    @JsonProperty("VoucherNumber")
    private Long id;

    @JsonProperty("TransactionDate")
    private String transactionDate;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("ReferenceNumber")
    private String referenceNumber;

    @JsonProperty("Year")
    private Integer year;

    public String getVoucherSeries() {
        return voucherSeries;
    }

    public void setVoucherSeries(String voucherSeries) {
        this.voucherSeries = voucherSeries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String  getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
