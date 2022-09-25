package spring.ioc.dependency.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.ioc.dependency.lookup.pojo.User;

/**
 * 构建BeanDefinition的方式案例
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanDefinitionDemo.class);
        buildMode(applicationContext);
        abstractBeanDefinition(applicationContext);
        applicationContext.refresh();
        System.out.println(applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    public static void buildMode(BeanDefinitionRegistry registry){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id",1);
        builder.addPropertyValue("name","stopping");
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        System.out.println(beanDefinition);
        //BeanDefinition还可以继续对元信息进行编辑
        //使用命名模式注册
        registry.registerBeanDefinition("user",beanDefinition);
    }

    public static void abstractBeanDefinition(BeanDefinitionRegistry registry){
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id",1);
        mutablePropertyValues.addPropertyValue("name","stopping");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
        System.out.println(genericBeanDefinition);
        //使用非命名模式
        BeanDefinitionReaderUtils.registerWithGeneratedName(genericBeanDefinition,registry);
    }
}
