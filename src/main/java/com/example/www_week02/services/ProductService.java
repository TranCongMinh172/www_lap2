package com.example.www_week02.services;




import com.example.www_week02.models.Product;
import com.example.www_week02.models.ProductPrice;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    boolean insert(Product product) throws Exception;
    Optional<Product> findById(Long id) throws Exception;
    List<Product> getAll() throws Exception;
    boolean update(Product product) throws Exception;
     boolean delete(Long id) throws Exception;
    List<Product> getAllActiveProduct(int status) throws Exception;
}
