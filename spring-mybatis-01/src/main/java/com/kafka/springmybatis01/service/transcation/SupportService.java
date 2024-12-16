package com.kafka.springmybatis01.service.transcation;

import com.kafka.springmybatis01.entity.Coupon;
import com.kafka.springmybatis01.entity.User;
import com.kafka.springmybatis01.service.CouponService;
import com.kafka.springmybatis01.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * supports传播属性验证
 */
@Service
public class SupportService {

    @Resource
    private UserService userService;

    @Resource
    private SubService subService;

    /**
     * 外部方法存在事务，Supports则应该有事务并且是同一个事务
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredToSupport(){
        System.out.println("当前外部事务为required");
        User user = new User().setPassword("123").setUsername("required");
        userService.insert(user,false);

        subService.support();
        System.out.println("support执行完成");

        throw new RuntimeException("has ex");
    }

    /**
     * 外部不存在事务，则supports属性就不会有事务，理论上即使内部事务发生异常但数据都写入了
     */
    public void notTransactionalToSupport(){
        System.out.println("当前外部事务为required");
        User user = new User().setPassword("123").setUsername("required");
        userService.insert(user,false);

        subService.supportException();
        System.out.println("support执行完成");
    }


}
