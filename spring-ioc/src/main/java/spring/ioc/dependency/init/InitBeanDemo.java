package spring.ioc.dependency.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import spring.ioc.dependency.init.pojo.UserServiceImpl;

/**
 * 初始化bean三种操作
 */
@Configuration
public class InitBeanDemo {

    public static void main(String[] args) {
        //通过注解配置获取上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将InitBeanDemo注册到容器中
        applicationContext.register(InitBeanDemo.class);
        //加载bean到容器
        applicationContext.refresh();
        System.out.println("应用上下文已经启动...");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        System.out.println(userService.getInitMethodName());
        applicationContext.close();
    }

    /**
     * 作为bean加入到容器
     * @return
     */
    @Bean(initMethod = "initUserService")
    @Lazy
    public UserServiceImpl userService(){
        System.out.println("获取userServiceImpl BEAN");
        return new UserServiceImpl();
    }
}
