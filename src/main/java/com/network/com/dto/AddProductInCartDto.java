package com.network.com.dto;

import lombok.Data;

@Data

public class AddProductInCartDto {
    private Long userId;
    private Long productId;
}
