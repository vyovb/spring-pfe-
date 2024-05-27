package com.network.com.repository;



import com.network.com.entity.Order;
import com.network.com.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
    List<Order> findAllByOrderStatusIn(List<OrderStatus> orderStatusList);
    List<Order> findByUserIdAndOrderStatusIn(Long userId, List<OrderStatus> orderStatus);

}
