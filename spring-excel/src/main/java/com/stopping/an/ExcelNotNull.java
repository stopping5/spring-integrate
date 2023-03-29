package com.stopping.an;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname: ExcelNotNull
 * @Description: TODO
 * @Date: 2023/3/28 4:15 下午
 * @author: stopping
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface ExcelNotNull {
    String value() default "";
}
