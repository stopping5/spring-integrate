package spring.ioc.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.dependency.injection.service.UserServiceImpl;

/**
 * 依赖注入案例
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-content.xml");
        //在xml声明userServiceImplbean，通过Autowire byType自动注入有set的参数
        UserServiceImpl userService = (UserServiceImpl)beanFactory.getBean("userServiceImpl");
        System.out.println(userService.getUsers());
        //org.springframework.beans.factory.support.DefaultListableBeanFactory
        //依赖注入的bean跟依赖查找的bean并不是同个内存地址，说明来源不一致
        System.out.println(userService.getBeanFactory());
        System.out.println(beanFactory == userService.getBeanFactory());
    }
}
