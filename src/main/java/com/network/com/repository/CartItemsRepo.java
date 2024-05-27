package com.network.com.repository;

import com.network.com.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CartItemsRepo extends JpaRepository<CartItems,Long> {
    Optional<CartItems>findByProductIdAndOrderIdAndUserId(Long productId, Long orderId, Long userId);
}
