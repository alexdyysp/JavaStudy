package com.Study.Annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String testAnnoValue() default "myValue";
}
