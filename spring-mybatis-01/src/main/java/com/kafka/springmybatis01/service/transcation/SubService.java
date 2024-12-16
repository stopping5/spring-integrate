package com.kafka.springmybatis01.service.transcation;

import com.kafka.springmybatis01.entity.Coupon;
import com.kafka.springmybatis01.service.CouponService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 子事务
 */
@Service
public class SubService {

    @Resource
    private CouponService couponService;

    /**
     * 验证required传播属性，事务是否在同一个事务中。
     * 结论：是在同一个事务中
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required(){
        Coupon coupon = new Coupon();
        coupon.setName("优惠券");
        couponService.insertCoupon(coupon,true);
    }

    /**
     * 验证required传播属性，事务是否在同一个事务中。
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiredNew(boolean f){
        Coupon coupon = new Coupon();
        coupon.setName("优惠券");
        couponService.insertCoupon(coupon,f);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void support(){
        System.out.println("support方法当前传播属性为 supports");
        Coupon coupon = new Coupon();
        coupon.setName("优惠券");
        couponService.insertCoupon(coupon,false);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supportException(){
        System.out.println("support方法当前传播属性为 supports");
        Coupon coupon = new Coupon();
        coupon.setName("优惠券");
        couponService.insertCoupon(coupon,false);

        throw new RuntimeException("has ex");
    }


    public void requiredNotTransactional(){
        Coupon coupon = new Coupon();
        coupon.setName("优惠券");
        couponService.insertCoupon(coupon,true);
    }
}
