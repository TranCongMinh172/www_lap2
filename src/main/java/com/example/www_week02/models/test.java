package com.example.www_week02.models;

import com.example.www_week02.services.ProductPriceService;
import com.example.www_week02.services.impls.ProductPriceImpl;

import java.util.Optional;

public class test {
    public static void main(String[] args) {
        ProductPriceService productPriceService = new ProductPriceImpl();
        Optional<ProductPrice> productPriceOptional = null;
        try {
            productPriceOptional = productPriceService.findByProductId(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ProductPrice productPrice = productPriceOptional.orElse(new ProductPrice());
        System.out.println(productPrice);
    }
}
