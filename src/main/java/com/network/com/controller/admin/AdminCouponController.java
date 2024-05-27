package com.network.com.controller.admin;


import com.network.com.entity.Coupon;
import com.network.com.exception.ValidationException;
import com.network.com.services.admin.coupon.AdminCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin/coupons")
@RequiredArgsConstructor
public class AdminCouponController {

    private final AdminCouponService adminCouponService;
    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon){
        try{
            Coupon createdCoupon=adminCouponService.createCoupon(coupon);
            return  ResponseEntity.ok(createdCoupon);
        }catch (ValidationException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
    @GetMapping
    @CrossOrigin("*")
    public ResponseEntity<List<Coupon>>getAllCoupons(){
        return ResponseEntity.ok(adminCouponService.getAllCoupons());
    }
}
