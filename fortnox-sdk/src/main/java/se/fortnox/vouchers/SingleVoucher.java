package se.fortnox.vouchers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SingleVoucher {
    @JsonProperty("Voucher")
    private Voucher voucher;

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
