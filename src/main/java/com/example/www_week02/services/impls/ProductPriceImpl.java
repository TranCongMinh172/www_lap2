package com.example.www_week02.services.impls;



import com.example.www_week02.models.ProductPrice;
import com.example.www_week02.repositories.ProductPriceRepository;
import com.example.www_week02.services.ProductPriceService;

import java.util.Optional;

public class ProductPriceImpl implements ProductPriceService {
    private final ProductPriceRepository repository;

    public ProductPriceImpl() {
        repository = new ProductPriceRepository();
        repository.setType(ProductPrice.class);
    }
    @Override
    public boolean insert(ProductPrice  productPrice) throws Exception {
        return repository.insert(productPrice);
    }

    @Override
    public Optional<ProductPrice> findByProductId(Long productId) throws Exception {
        return repository.findByProductId(productId);
    }
    @Override
    public boolean updatePrice(long id, double price) {
        return repository.updatePrice(id,price);
    }

}
