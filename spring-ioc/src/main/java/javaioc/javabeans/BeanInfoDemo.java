package javaioc.javabeans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import javaioc.pojo.Person;
import java.util.stream.Stream;

/**
 * jAVA IOC实现测试demo
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo personBeanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        //通过BeanInfo可以获取到Bean的元信息包括属性、类型、方法、
        Stream.of(personBeanInfo.getPropertyDescriptors()).forEach(
                propertyDescriptor -> {
                    System.out.println(propertyDescriptor);
                    //java.beans.PropertyDescriptor[name=age; propertyType=class java.lang.Integer; readMethod=public java.lang.Integer javaioc.pojo.Person.getAge(); writeMethod=public void javaioc.pojo.Person.setAge(java.lang.Integer)]
                    //java.beans.PropertyDescriptor[name=name; propertyType=class java.lang.String; readMethod=public java.lang.String javaioc.pojo.Person.getName(); writeMethod=public void javaioc.pojo.Person.setName(java.lang.String)]
                }
        );
    }
}
