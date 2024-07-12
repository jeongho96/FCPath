//package com.fc.path.fcpath.validation_part.annotation;
//
//
//import com.fc.path.fcpath.validation_part.validator.YearMonthValidator;
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import jakarta.validation.constraints.NotBlank;
//
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//@Constraint(validatedBy = YearMonthValidator.class)
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@NotBlank
//public @interface YearMonth {
//
//    // groups와 payload는 기본적으로 있어야 하는 코드.
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//
//    String message() default "Invalid date format. Expected yyyyMMdd";
//
////    String regexp() default "\\d{4}(0[1-9]|1[0-2])";
//    String pattern() default "yyyyMMdd";
//}
