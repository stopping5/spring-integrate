package spring.ioc.dependency.injection.service;

import org.springframework.beans.factory.BeanFactory;
import spring.ioc.dependency.lookup.pojo.User;

import java.util.Collection;

/**
 * 用户业务逻辑
 */
public class UserServiceImpl {

    private Collection<User> users;

    private BeanFactory beanFactory;

    /**
     * 通过set方法注入，在xml文件通过给UserServiceImpl bean自动注入User类型的bean到users中
     * @param users
     */
    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    /**
     * 自动注入beanFactory
     * @param beanFactory
     */
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }


    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }


}
