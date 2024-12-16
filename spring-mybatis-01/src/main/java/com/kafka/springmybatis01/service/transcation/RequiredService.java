package com.kafka.springmybatis01.service.transcation;

import com.kafka.springmybatis01.dao.UserMapper;
import com.kafka.springmybatis01.entity.Coupon;
import com.kafka.springmybatis01.entity.User;
import com.kafka.springmybatis01.service.CouponService;
import com.kafka.springmybatis01.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 验证事务传播属性
 * 事务传播类型: RequiredService
 */
@Service
public class RequiredService {

    @Resource
    private UserService userService;
    @Resource
    private SubService subService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        User user = new User().setPassword("123").setUsername("xs");
        System.out.println("save user = " +  user.toString());
        userService.insert(user,false);
        System.out.println("调用其他事务方法");
        subService.required();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredInNotTransaction() {
        User user = new User().setPassword("123").setUsername("xs");
        System.out.println("save user = " +  user.toString());
        userService.insert(user,false);
        System.out.println("调用其他事务方法");
        subService.requiredNotTransactional();

        throw new RuntimeException("has ex");
    }

}

