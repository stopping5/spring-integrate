package spring.ioc.dependency.init.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

public class UserServiceImpl implements InitializingBean {
    private String initMethodName = "";

    public String getInitMethodName() {
        return initMethodName;
    }

    /**
     * 初始化完UserServiceImpl之后调用POSTConstruct的方法
     * 应用场景：
     * 当类被加载后，部分参数需要类加载完成之后再注入的情况
     */
    @PostConstruct
    public void init(){
        initMethodName = "init";
        System.out.println("通过@Configuration初始化UserServiceImpl");
    }

    /**
     * 实现InitializingBean 覆盖方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        initMethodName = "afterPropertiesSet";
        System.out.println("通过afterPropertiesSet初始化UserServiceImpl");
    }

    /**
     * 通过@bean初始化bean
     */
    public void initUserService(){
        initMethodName = "initMethodName";
        System.out.println("通过initMethodName初始化UserServiceImpl");
    }
}
