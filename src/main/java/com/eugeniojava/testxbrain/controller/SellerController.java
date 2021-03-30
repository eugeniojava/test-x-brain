package com.eugeniojava.testxbrain.controller;

import com.eugeniojava.testxbrain.controller.request.SellerRequest;
import com.eugeniojava.testxbrain.controller.response.SellerReportResponse;
import com.eugeniojava.testxbrain.controller.response.SellerResponse;
import com.eugeniojava.testxbrain.service.SellerService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("${api.prefix}/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<List<SellerResponse>> getAll() {
        return sellerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponse> getById(@PathVariable Long id) {
        return sellerService.getById(id);
    }

    @PostMapping
    public ResponseEntity<SellerResponse> create(
            @Valid @RequestBody SellerRequest sellerRequest) {
        return sellerService.create(sellerRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody SellerRequest sellerRequest) {
        return sellerService.update(id, sellerRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return sellerService.delete(id);
    }

    @GetMapping("/reportBetween")
    public ResponseEntity<List<SellerReportResponse>> getSellersReportBetween(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate endDate) {
        return sellerService.getSellersReportBetween(startDate, endDate);
    }
}
