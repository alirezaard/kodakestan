package com.kodakestan.kodak.Exceptions.handler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandledException {
    ExceptionType type();

    String[] params() default {};

    String description() default "";
}
