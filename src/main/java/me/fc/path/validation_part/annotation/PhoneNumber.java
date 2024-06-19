//package com.fc.path.fcpath.validation_part.annotation;
//
//
//import com.fc.path.fcpath.validation_part.validator.PhoneNumberValidator;
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//// 검증 validator를 연결.
//@Constraint(validatedBy = PhoneNumberValidator.class)
//// 적용범위 지정
//@Target({ElementType.FIELD})
//// 실행 시에만 적용.
//@Retention(RetentionPolicy.RUNTIME)
//public @interface PhoneNumber {
//
//    // groups와 payload는 기본적으로 있어야 하는 코드.
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//
//    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex) 000-0000-0000";
//
//    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";
//}
