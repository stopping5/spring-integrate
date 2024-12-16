package com.kafka.springmybatis01.service.transcation;


import com.kafka.springmybatis01.dao.UserMapper;
import com.kafka.springmybatis01.entity.Coupon;
import com.kafka.springmybatis01.entity.User;
import com.kafka.springmybatis01.service.CouponService;
import com.kafka.springmybatis01.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring事务传播验证
 * 事务传播指的是在一个事务方法调用另一个事务方法时，当前方法的事务应该如何进行管理。
 * 结论
 * 1. 如果一个普通方法调用事务方法，那么事务是不会进行传播的
 * 2. 所以本案例主要讨论事务方法调用事务方法，不同的传播属性形成的事务结果
 **/

 @Service
public class TransactionalDemo {

    @Resource
    private UserService userService;

    @Resource
    private CouponService couponService;


    /**
     * REQUIRED 保证当前事务传播只有一个事务
     * 含义： 如果当前有事务，则加入当前事务；如果没有事务，则新建一个事务。
     * 适用场景： 最常用的事务传播行为，适合绝大多数业务场景。
     *
     * 当前方法存在事务，调用外部两个事务
     * 结论：两个外部事务都存在一个事务中
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void required(){
        User user = new User().setPassword("123").setUsername("xs");
        userService.insert(user,false);
        Coupon coupon = new Coupon();
        coupon.setName("新人优惠");
        couponService.insertCoupon(coupon,true);

    }


    /**
     * 当前不存在事务，调用外部事务
     *
     * 失效场景:
     * 自调用问题： 当同一个类中的非事务方法调用事务方法时，由于代理机制的原因，事务可能不会生效。这是因为自调用不会经过代理，因此事务增强不会应用。
     */
    public void requiredOtherSelf(){
        User user = new User().setPassword("123").setUsername("xs");
        userService.insert(user,false);
        //事务无法生效
        this.requiredOne();
    }


    /**
     * 当前方法不存在事务，调用外部事务方法
     * 结论：事务传播不会向上传递，当前方法不存在事务，而子方法事务生效
     */
    public void requiredOther(){
        User user = new User().setPassword("123").setUsername("xs");
        userService.insert(user,false);
        Coupon coupon = new Coupon();
        coupon.setName("新人优惠");
        couponService.insertCouponTransaction(coupon,true);
    }

    /**
     * 外部事务存在
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredOne(){
        Coupon coupon = new Coupon();
        coupon.setName("新人优惠");
        couponService.insertCoupon(coupon,true);

    }

    public void notRequired(){

    }
}
