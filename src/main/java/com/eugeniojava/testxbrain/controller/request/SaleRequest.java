package com.eugeniojava.testxbrain.controller.request;

import com.eugeniojava.testxbrain.model.Sale;
import com.eugeniojava.testxbrain.model.Seller;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfSale;

    @Positive
    private BigDecimal amount;

    @Positive
    private Long sellerId;

    public Sale toEntity(Seller seller) {
        return new Sale(dateOfSale, amount, seller);
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getSellerId() {
        return sellerId;
    }
}
