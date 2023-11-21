package com.example.www_week02.services;



import com.example.www_week02.models.ProductPrice;

import java.util.Optional;

public interface ProductPriceService {
    boolean insert(ProductPrice productPrice) throws Exception;
    Optional<ProductPrice> findByProductId(Long productId) throws Exception;
    public boolean updatePrice(long id, double price);
}
