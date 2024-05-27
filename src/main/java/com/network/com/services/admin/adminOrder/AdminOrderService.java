package com.network.com.services.admin.adminOrder;

import com.network.com.dto.OrderDto;

import java.util.List;

public interface AdminOrderService  {
    List<OrderDto> getAllPlaceOrders();
    public OrderDto  changeOrderStatus(Long orderId,String status);
}
