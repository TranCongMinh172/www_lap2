package com.example.www_week02.repositories;

import com.example.www_week02.models.ProductImage;

public class ProductImageRepository extends  CRUDRepository<ProductImage>{
    public ProductImageRepository() {
    }

    @Override
    public void setType(Class<ProductImage> type) {
        super.setType(type);
    }
}
