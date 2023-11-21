package com.example.www_week02.repositories;

import com.example.www_week02.models.Order;

public class OrderRepository extends  CRUDRepository<Order>{
    public OrderRepository() {
    }

    @Override
    public void setType(Class<Order> type) {
        super.setType(type);
    }
}
