package com.stopping.orgincode.annotion;
import com.stopping.orgincode.config.OnLinuxCondition;
import org.springframework.context.annotation.Conditional;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname: ConditionalOnSystem
 * @Date: 2022/5/27 11:04 上午
 * @author: stopping
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnLinuxCondition.class)
public @interface ConditionalOnSystem {
    /**
     * 标记当前环境
     * @return
     */
    String environment() default "";
}
