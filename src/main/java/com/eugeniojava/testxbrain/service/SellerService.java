package com.eugeniojava.testxbrain.service;

import com.eugeniojava.testxbrain.controller.request.SellerRequest;
import com.eugeniojava.testxbrain.controller.response.SellerReportResponse;
import com.eugeniojava.testxbrain.controller.response.SellerResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface SellerService {

    ResponseEntity<List<SellerResponse>> getAll();

    ResponseEntity<SellerResponse> getById(Long id);

    ResponseEntity<SellerResponse> create(SellerRequest sellerRequest);

    ResponseEntity<SellerResponse> update(Long id, SellerRequest sellerRequest);

    ResponseEntity<?> delete(Long id);

    ResponseEntity<List<SellerReportResponse>> getSellersReportBetween(
            LocalDate startDate, LocalDate endDate);
}
