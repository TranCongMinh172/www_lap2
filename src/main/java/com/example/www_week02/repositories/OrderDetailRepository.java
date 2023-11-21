package com.example.www_week02.repositories;

import com.example.www_week02.models.OrderDetail;

public class OrderDetailRepository extends CRUDRepository<OrderDetail>{
    public OrderDetailRepository() {
    }

    @Override
    public void setType(Class<OrderDetail> type) {
        super.setType(type);
    }
}
