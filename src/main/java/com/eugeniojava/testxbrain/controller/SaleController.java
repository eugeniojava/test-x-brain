package com.eugeniojava.testxbrain.controller;

import com.eugeniojava.testxbrain.controller.request.SaleRequest;
import com.eugeniojava.testxbrain.controller.response.SaleResponse;
import com.eugeniojava.testxbrain.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleResponse>> getAll() {
        return saleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponse> getById(@PathVariable Long id) {
        return saleService.getById(id);
    }

    @PostMapping
    public ResponseEntity<SaleResponse> create(
            @Valid @RequestBody SaleRequest saleRequest) {
        return saleService.create(saleRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody SaleRequest saleRequest) {
        return saleService.update(id, saleRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return saleService.delete(id);
    }
}
