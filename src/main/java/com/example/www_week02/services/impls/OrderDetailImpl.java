package com.example.www_week02.services.impls;


import com.example.www_week02.models.OrderDetail;
import com.example.www_week02.repositories.OrderDetailRepository;
import com.example.www_week02.services.OrderDetailService;

public class OrderDetailImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    public OrderDetailImpl() {
        orderDetailRepository = new OrderDetailRepository();
    }
    @Override
    public boolean insert(OrderDetail orderDetail) {
        return orderDetailRepository.insert(orderDetail);
    }
}
