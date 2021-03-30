package com.eugeniojava.testxbrain.repository;

import com.eugeniojava.testxbrain.controller.response.SellerReportResponse;
import com.eugeniojava.testxbrain.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query("SELECT new com.eugeniojava.testxbrain.controller.response" +
            ".SellerReportResponse(seller.name, COUNT(sale.id)," +
            " COUNT(sale.id) / (1.0 + ABS(DATEDIFF(DAY, ?1, ?2)))) " +
            "FROM Seller seller JOIN Sale sale" +
            " ON seller.id = sale.seller.id " +
            "WHERE sale.dateOfSale BETWEEN ?1 AND ?2" +
            "GROUP BY seller.id")
    List<SellerReportResponse> getSellersReportBetween(LocalDate startDate,
                                                       LocalDate endDate);
}
