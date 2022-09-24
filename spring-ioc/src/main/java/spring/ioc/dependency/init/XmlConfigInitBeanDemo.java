package spring.ioc.dependency.init;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import spring.ioc.dependency.lookup.pojo.User;

import java.util.Map;

/**
 * 通过XML配置获取BeanFactory 容器
 */
public class XmlConfigInitBeanDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String xmlLocation = "classpath:/META-INF/dependency-lookup-content.xml";
        int loadBeanCount = reader.loadBeanDefinitions(xmlLocation);
        System.out.println("加载Bean的数量:"+loadBeanCount);
        lookupByCollection(beanFactory);
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
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有User的对象:"+users);
        }
    }
}
