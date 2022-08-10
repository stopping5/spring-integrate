package com.stopping.orgincode.config;

import com.stopping.orgincode.annotion.ConditionalOnSystem;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.List;

/**
 * @Classname: OnLinuxCondition
 * @Date: 2022/5/27 11:05 上午
 * @author: stopping
 */
public class OnLinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        System.out.println("load Condition...");
        return true;
    }
}
