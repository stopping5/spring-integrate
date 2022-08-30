package spring.ioc.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.dependency.lookup.annotation.Super;
import spring.ioc.dependency.lookup.pojo.User;

import java.util.Map;

/**
 * Spring IOC 依赖查找示例
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        //从xml文件读取BeanFactory
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-content.xml");
        //lookup(beanFactory);
    }

    /**
     * 依赖查找
     * @param beanFactory
     */
    private static void lookup(BeanFactory beanFactory) {
        //通过bean的名称查找
        lookupByNameRealTime(beanFactory);
        lookupByNameLazy(beanFactory);
        //通过类型查找
        //lookupByType(beanFactory);
        lookupByCollection(beanFactory);
        //通过注解方式查找
        lookupByAnnotation(beanFactory);
    }

    /**
     * 通过注解查找bean
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到@Super所有User的对象:"+users);
        }
    }

    /**
     * 查找集合bean
     * 例如在XML配置了两个User的Bean
     * 查找到所有User的对象:{user=User(name=stopping, id=1), user2=User(name=stopping2, id=2)}
     * @param beanFactory
     */
    private static void lookupByCollection(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User的对象:"+users);
        }
    }

    /**
     * 通过bean类型查找
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("通过类型实时查找:"+user);
    }

    /**
     * ObjectFactory 具体实现 ObjectFactoryCreatingFactoryBean
     * 通过ObjectFactoryCreatingFactoryBean避免通过beanfactory查找
     * @param beanFactory
     */
    private static void lookupByNameLazy(BeanFactory beanFactory) {
        //factorybean
        ObjectFactory<User> objectFactory =  (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找:"+user);
    }

    /**
     * 通过bean的名称查找 - 实时查找
     * @param beanFactory
     */
    private static void lookupByNameRealTime(BeanFactory beanFactory) {
        User user =  (User) beanFactory.getBean("user");
        System.out.println("直接通过beanFactory查找:"+user);
    }
}
