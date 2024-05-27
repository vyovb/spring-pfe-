package com.network.com.services.admin.coupon;


import com.network.com.entity.Coupon;
import com.network.com.exception.ValidationException;
import com.network.com.repository.CouponRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService {

private final CouponRepo couponRepo;
public Coupon createCoupon(Coupon coupon){
    if(couponRepo.existsByCode(coupon.getCode())){
        throw new ValidationException("Coupon code already exists.");
    }
    return couponRepo.save(coupon);
}
public List<Coupon> getAllCoupons(){
    return couponRepo.findAll();
}

}
