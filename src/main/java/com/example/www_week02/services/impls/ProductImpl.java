package com.example.www_week02.services.impls;



import com.example.www_week02.models.Product;
import com.example.www_week02.repositories.ProductRepository;
import com.example.www_week02.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ProductImpl implements ProductService {

    private final ProductRepository repository;
    public ProductImpl() {
        repository = new ProductRepository();
        repository.setType(Product.class);
    }
    @Override
    public boolean insert(Product product) throws Exception {
        return  repository.insert(product);
    }

    @Override
    public Optional<Product> findById(Long id) throws Exception {
        return repository.findById(id);
    }


    @Override
    public List<Product> getAll() throws Exception {
        return repository.getListResult("product")
                .stream()
                .collect(Collectors.toList());
    }


    @Override
    public boolean update(Product product) throws Exception {
        return repository.update(product);
    }
    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
    @Override
    public List<Product> getAllActiveProduct(int status){
        return repository.getAllActiveProduct(status);
    }
}
