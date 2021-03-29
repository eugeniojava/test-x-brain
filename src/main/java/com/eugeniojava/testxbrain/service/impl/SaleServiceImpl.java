package com.eugeniojava.testxbrain.service.impl;

import com.eugeniojava.testxbrain.controller.request.SaleRequest;
import com.eugeniojava.testxbrain.controller.response.SaleResponse;
import com.eugeniojava.testxbrain.model.Sale;
import com.eugeniojava.testxbrain.model.Seller;
import com.eugeniojava.testxbrain.repository.SaleRepository;
import com.eugeniojava.testxbrain.repository.SellerRepository;
import com.eugeniojava.testxbrain.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final SellerRepository sellerRepository;

    public SaleServiceImpl(SaleRepository saleRepository,
                           SellerRepository sellerRepository) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public ResponseEntity<List<SaleResponse>> getAll() {
        List<Sale> sales = saleRepository.findAll();

        if (!sales.isEmpty()) {
            return new ResponseEntity<>(SaleResponse.fromEntityList(sales),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<SaleResponse> getById(Long id) {
        Sale sale = saleRepository.findById(id).orElse(null);

        if (sale != null) {
            return new ResponseEntity<>(new SaleResponse(sale), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<SaleResponse> create(SaleRequest saleRequest) {
        Seller seller = sellerRepository
                .findById(saleRequest.getSellerId())
                .orElse(null);

        if (seller != null) {
            Sale sale = saleRepository.save(saleRequest.toEntity(seller));

            return new ResponseEntity<>(new SaleResponse(sale),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<SaleResponse> update(
            Long id, SaleRequest saleRequest) {
        Sale sale = saleRepository.findById(id).orElse(null);
        Seller seller = sellerRepository
                .findById(saleRequest.getSellerId())
                .orElse(null);

        if (sale != null) {
            if (seller != null) {
                sale.setDateOfSale(saleRequest.getDateOfSale());
                sale.setAmount(saleRequest.getAmount());
                sale.setSeller(seller);

                return new ResponseEntity<>(
                        new SaleResponse(saleRepository.save(sale)),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (saleRepository.findById(id).isPresent()) {
            saleRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
