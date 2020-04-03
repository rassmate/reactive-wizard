package se.fortnox.vouchers;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty("Comments")
    private String comments;

    @JsonProperty("CostCenter")
    private String costCenter;

    @JsonProperty("Project")
    private Integer project;

    @JsonProperty("VoucherRows")
    private List<VoucherRow> voucherRows;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }
}
