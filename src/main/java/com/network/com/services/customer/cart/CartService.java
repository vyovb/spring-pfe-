package com.network.com.services.customer.cart;



import com.network.com.dto.AddProductInCartDto;
import com.network.com.dto.OrderDto;
import com.network.com.dto.PlaceOrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);
    OrderDto applyCoupon(Long userId,String code);
    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto placeOrder(PlaceOrderDto placeOrderDto);
    List<OrderDto> getMyPlacedOrders(Long userId);
}
