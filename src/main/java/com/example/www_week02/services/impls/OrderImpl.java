package com.example.www_week02.services.impls;



import com.example.www_week02.models.Order;
import com.example.www_week02.repositories.OrderRepository;
import com.example.www_week02.services.OrderService;

import java.util.Optional;

public class OrderImpl implements OrderService {
    private final OrderRepository repository;

    public OrderImpl() {
        repository = new OrderRepository();
        repository.setType(Order.class);
    }
    @Override
    public boolean insert(Order order) throws Exception {
        return repository.insert(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

}
