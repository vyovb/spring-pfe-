package com.network.com.services.admin.coupon;



import com.network.com.entity.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdminCouponService {
    Coupon createCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
