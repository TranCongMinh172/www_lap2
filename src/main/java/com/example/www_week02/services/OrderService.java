package com.example.www_week02.services;



import com.example.www_week02.models.Order;

import java.util.Optional;

public interface OrderService {
    boolean insert(Order order) throws Exception;
    Optional<Order> findById(Long id);

}
