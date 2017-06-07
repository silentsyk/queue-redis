package com.funnyy.component.queue.queueapi.annotation;

import java.lang.annotation.*;

/**
 * Created by sky on 17-5-18.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Resource {
    String value() default "";
}
