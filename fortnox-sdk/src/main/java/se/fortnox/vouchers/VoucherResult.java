package se.fortnox.vouchers;

import com.fasterxml.jackson.annotation.JsonProperty;
import se.fortnox.FortnoxResult;

import java.util.ArrayList;
import java.util.List;

public class VoucherResult extends FortnoxResult {
    @JsonProperty("Vouchers")
    private List<Voucher> vouchers = new ArrayList<>();

    public VoucherResult() {
    }

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }
}
