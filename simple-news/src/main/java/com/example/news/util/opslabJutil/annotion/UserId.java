package com.example.news.util.opslabJutil.annotion;

import java.lang.annotation.*;

/**
 * 用于标记用户标识的注解,常用于参数
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserId {
    String value() default "";
}
