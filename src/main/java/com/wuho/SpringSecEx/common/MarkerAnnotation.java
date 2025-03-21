package com.wuho.SpringSecEx.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
@Target(ElementType.METHOD)
public @interface MarkerAnnotation {
    int value();
}
