package com.eugeniojava.testxbrain.service.impl;

import com.eugeniojava.testxbrain.controller.request.SellerRequest;
import com.eugeniojava.testxbrain.controller.response.SellerResponse;
import com.eugeniojava.testxbrain.model.Seller;
import com.eugeniojava.testxbrain.repository.SellerRepository;
import com.eugeniojava.testxbrain.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public ResponseEntity<List<SellerResponse>> getAll() {
        List<Seller> sellers = sellerRepository.findAll();

        if (!sellers.isEmpty()) {
            return new ResponseEntity<>(SellerResponse.fromEntityList(sellers),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<SellerResponse> getById(Long id) {
        Seller seller = sellerRepository.findById(id).orElse(null);

        if (seller != null) {
            return new ResponseEntity<>(new SellerResponse(seller),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<SellerResponse> create(SellerRequest sellerRequest) {
        Seller seller =
                sellerRepository.save(new Seller(sellerRequest.getName()));

        return new ResponseEntity<>(new SellerResponse(seller),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<SellerResponse> update(Long id,
                                                 SellerRequest sellerRequest) {
        Seller seller = sellerRepository.findById(id).orElse(null);

        if (seller != null) {
            seller.setName(sellerRequest.getName());

            return new ResponseEntity<>(
                    new SellerResponse(sellerRepository.save(seller)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if (sellerRepository.findById(id).isPresent()) {
            sellerRepository.deleteById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
