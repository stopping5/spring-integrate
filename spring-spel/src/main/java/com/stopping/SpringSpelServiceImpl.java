package com.stopping;

import com.stopping.pojo.User;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

/**
 * @Classname: SpringSpelServiceImpl
 * @Date: 2022/9/15 11:43 上午
 * @author: stopping
 */
@Service
public class SpringSpelServiceImpl {
    /**
     * spel表达式解析器
     */
    private static SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    /**
     * 参数名发现器
     */
    private DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    public static void main(String[] args) {
        valuePoJODemo();
    }

    public void simpleDemo(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    public static void valueDemo(){
        EvaluationContext context = new StandardEvaluationContext();
        //设置变量
        context.setVariable("newName","new Stopping");
        //编写表达式
        String newName =  spelExpressionParser.parseExpression("#newName").getValue(context).toString();
        System.out.println(newName);
    }

    public static void valuePoJODemo(){
        User user = new User("stopping",18);
        EvaluationContext context = new StandardEvaluationContext();
        //设置变量
        //将实体类User映射的参数名为user
        //在SpEL中通过#user即可获取到变量，#user.username 可以映射到内部参数
        context.setVariable("user",user);
        //编写表达式
        String newName =  spelExpressionParser.parseExpression("#user.username").getValue(context).toString();
        System.out.println(newName);
    }
}
