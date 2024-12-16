package com.kafka.springmybatis01.service.transcation;

import com.kafka.springmybatis01.entity.User;
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
public class RequiredNewService {

    @Resource
    private UserService userService;
    @Resource
    private SubService subService;

    /**
     * 当前方法为REQUIRED，但是子方法是REQUIRES_NEW
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredToNew() {
        User user = new User().setPassword("123").setUsername("xs");
        System.out.println("save user = " +  user.toString());
        userService.insert(user,false);
        System.out.println("调用REQUIRES_NEW事务方法");
        subService.required();
    }

    /**
     * 内层抛异常则外层也会回滚
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredToRequiredNewIn() {
        User user = new User().setPassword("123").setUsername("xs");
        System.out.println("save user = " +  user.toString());
        userService.insert(user,false);
        System.out.println("调用REQUIRES事务方法");
        subService.requiredNew(true);
    }

    /**
     * 内层抛异常则外层也会回滚
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void requiredToRequiredNewOut() {
        User user = new User().setPassword("123").setUsername("xs");
        System.out.println("save user = " +  user.toString());
        userService.insert(user,false);
        System.out.println("调用REQUIRES事务方法");
        subService.requiredNew(false);

        System.out.println("外层发生异常");
        throw new RuntimeException("out method ex");
    }

}

