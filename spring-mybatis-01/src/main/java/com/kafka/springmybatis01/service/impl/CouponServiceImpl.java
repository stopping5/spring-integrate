package com.kafka.springmybatis01.service.impl;

import com.kafka.springmybatis01.dao.CouponMapper;
import com.kafka.springmybatis01.entity.Coupon;
import com.kafka.springmybatis01.service.CouponService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public void insertCoupon(Coupon coupon,boolean flag) {
        couponMapper.insert(coupon);

        if (flag) {
            throw new RuntimeException("has exception");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCouponTransaction(Coupon coupon, boolean flag) {
        couponMapper.insert(coupon);

        if (flag) {
            throw new RuntimeException("has exception");
        }
    }
}
