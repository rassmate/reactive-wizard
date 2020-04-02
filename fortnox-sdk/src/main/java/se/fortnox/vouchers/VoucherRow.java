package se.fortnox.vouchers;

public class VoucherRow {
    private Short account;
    private String costCenter;
    private String projectFollowUpId;
    private String transactionInformation;
    private double debit;
    private double credit;

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

    public String getProjectFollowUpId() {
        return projectFollowUpId;
    }

    public void setProjectFollowUpId(String projectFollowUpId) {
        this.projectFollowUpId = projectFollowUpId;
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
}
