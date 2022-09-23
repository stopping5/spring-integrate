package spring.ioc.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 单一依赖查找
 * @Classname: SimpleLookupDemo
 * @Date: 2022/9/21 2:44 下午
 * @author: stopping
 */

public class SimpleLookupDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SimpleLookupDemo.class);
        context.refresh();
        lookupByObjectProvider(context);
        context.close();
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext context) {
        ObjectProvider<String> objectProvider = context.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }

    @Bean
    public String helloWord(){
        return "helloWord";
    }

    @Bean
    public String nihao(){
        return "nihao";
    }
}
