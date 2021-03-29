package com.eugeniojava.testxbrain.controller.response;

import com.eugeniojava.testxbrain.model.Seller;

import java.util.List;
import java.util.stream.Collectors;

public class SellerResponse {

    private final Long id;
    private final String name;

    public SellerResponse(Seller seller) {
        id = seller.getId();
        name = seller.getName();
    }

    public static List<SellerResponse> fromEntityList(List<Seller> sellers) {
        return sellers
                .stream()
                .map(SellerResponse::new)
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
