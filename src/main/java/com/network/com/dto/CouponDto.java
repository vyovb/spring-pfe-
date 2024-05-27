package com.network.com.dto;

import lombok.Data;

import java.util.Date;





@Data
public class CouponDto {
    private Long id;
    private String name;
    private String code;
    private String discount;
    private Date expirationDate;
}
