package com.kafka.springmybatis01.service;

import com.kafka.springmybatis01.entity.Coupon;

public interface CouponService {

    void insertCoupon(Coupon coupon,boolean flag);

    void insertCouponTransaction(Coupon coupon,boolean flag);
}
