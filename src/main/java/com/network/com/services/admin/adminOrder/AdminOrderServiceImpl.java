package com.network.com.services.admin.adminOrder;

import com.network.com.dto.OrderDto;
import com.network.com.entity.Order;
import com.network.com.enums.OrderStatus;
import com.network.com.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {


    private final OrderRepo orderRepo;
    public List<OrderDto> getAllPlaceOrders(){
        List<Order> orderList=orderRepo.findAllByOrderStatusIn(List.of(OrderStatus.Placed,OrderStatus.Shipped,OrderStatus.Delivered));
        return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());


    }
    public OrderDto  changeOrderStatus(Long orderId,String status){
        Optional<Order>optionalOrder=orderRepo.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            if (Objects.equals(status,"shipped")){
                order.setOrderStatus(OrderStatus.Shipped);
            }else if(Objects.equals(status,"Delivered")){
                order.setOrderStatus(OrderStatus.Delivered);
            }
            return orderRepo.save(order).getOrderDto();
        }
        return null;
    }
}
