package com.stopping.aop;

import com.stopping.annotation.ValueMap;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * 参数映射AOP
 */
@Component
@Aspect
public class ValueMappingAOP {

    @Pointcut("@annotation(com.stopping.annotation.ValueMap)")
    public void valueMappingAspect(){
    }

    /**
     * spel表达式解析器
     */
    private SpelExpressionParser spelExpressionParser = new SpelExpressionParser();

    /**
     * 参数名发现器
     */
    private DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

    @Before("valueMappingAspect()")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature =(MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        //获取注释内容
        ValueMap valueMap = method.getAnnotation(ValueMap.class);

        String [] paramName = parameterNameDiscoverer.getParameterNames(method);
        Object[] args = joinPoint.getArgs();
        //SpEl环境上下文
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        //获取方法参数值
        for (int i = 0; i < paramName.length; i++) {
            System.out.println("获取参数:"+paramName[i]);
            evaluationContext.setVariable(paramName[i],args[i]);
        }
        String username = spelExpressionParser.parseExpression(valueMap.value()).getValue(evaluationContext).toString();
        System.out.println("实际获取到映射值："+username);
    }
}
