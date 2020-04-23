package se.fortnox.vouchers;

import javax.ws.rs.QueryParam;
import java.time.LocalDate;

public class VoucherFilter {
    @QueryParam("financialyeardate")
    private LocalDate financialYearDate;

    public LocalDate getFinancialYearDate() {
        return financialYearDate;
    }

    public void setFinancialYearDate(LocalDate financialYearDate) {
        this.financialYearDate = financialYearDate;
    }
}
