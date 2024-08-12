package org.delivery.api.common.annotation;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 어노테이션이 겹치면 내용이 헷갈리기 때문에, 용도에 따라 비즈니스 로직만
// 처리하는 어노테이션을 별도로 생성.
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface Business {

    @AliasFor(annotation = Service.class)
    String value() default "";
}
