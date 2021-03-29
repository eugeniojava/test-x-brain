package com.eugeniojava.testxbrain.controller.request;

import javax.validation.constraints.NotBlank;

public class SellerRequest {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }
}
