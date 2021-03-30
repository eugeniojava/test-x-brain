package com.eugeniojava.testxbrain.controller.response;

public class SellerReportResponse {

    private final String name;
    private final Long totalSales;
    private final Double averageDailySales;

    public SellerReportResponse(String name, Long totalSales,
                                Double averageDailySales) {
        this.name = name;
        this.totalSales = totalSales;
        this.averageDailySales = averageDailySales;
    }

    public String getName() {
        return name;
    }

    public Long getTotalSales() {
        return totalSales;
    }

    public Double getAverageDailySales() {
        return averageDailySales;
    }
}
