package se.fortnox.vouchers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoucherRow {
    @JsonProperty("Account")
    private Short account;

    @JsonProperty("CostCenter")
    private String costCenter;

    @JsonProperty("Debit")
    private double debit;

    @JsonProperty("Credit")
    private double credit;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Project")
    private String project;

    @JsonProperty("Removed")
    private boolean removed;

    @JsonProperty("TransactionInformation")
    private String transactionInformation;

    public Short getAccount() {
        return account;
    }

    public void setAccount(Short account) {
        this.account = account;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getTransactionInformation() {
        return transactionInformation;
    }

    public void setTransactionInformation(String transactionInformation) {
        this.transactionInformation = transactionInformation;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }
}
