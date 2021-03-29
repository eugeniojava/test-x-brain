package com.eugeniojava.testxbrain.service;

import com.eugeniojava.testxbrain.controller.request.SaleRequest;
import com.eugeniojava.testxbrain.controller.response.SaleResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaleService {

    ResponseEntity<List<SaleResponse>> getAll();

    ResponseEntity<SaleResponse> getById(Long id);

    ResponseEntity<SaleResponse> create(SaleRequest saleRequest);

    ResponseEntity<SaleResponse> update(Long id, SaleRequest saleRequest);

    ResponseEntity<?> delete(Long id);
}
