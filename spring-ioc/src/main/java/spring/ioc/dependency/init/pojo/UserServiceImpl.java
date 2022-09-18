package spring.ioc.dependency.init.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UserServiceImpl implements InitializingBean, DisposableBean {
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

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy:销毁UserServiceImpl");
    }



    /**
     * 通过@bean destroyMethod 在bean销毁的时候回调用
     */
    private void destroyUserService() {
        System.out.println("destroyMethod:销毁UserServiceImpl");
    }

    /**
     * 销毁Bean前调用
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean:销毁UserServiceImpl");
    }
}
