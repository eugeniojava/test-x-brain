package com.eugeniojava.testxbrain.controller.response;

import com.eugeniojava.testxbrain.model.Sale;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SaleResponse {

    private final Long id;
    private final LocalDate dateOfSale;
    private final BigDecimal amount;
    private final Long sellerId;
    private final String sellerName;

    public SaleResponse(Sale sale) {
        id = sale.getId();
        dateOfSale = sale.getDateOfSale();
        amount = sale.getAmount();
        sellerId = sale.getSeller().getId();
        sellerName = sale.getSeller().getName();
    }

    public static List<SaleResponse> fromEntityList(List<Sale> sales) {
        return sales
                .stream()
                .map(SaleResponse::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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

    public String getSellerName() {
        return sellerName;
    }
}
