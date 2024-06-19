//package com.fc.path.fcpath.validation_part.validator;
//
//import com.fc.path.fcpath.validation_part.annotation.PhoneNumber;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//import java.util.regex.Pattern;
//
//// ConstraintValidator를 통해서 설정할 어노테이션과 입력값을 지정.
//public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
//
//    private String regexp;
//
//    // 초기화 시에 해당 어노테이션에 있는 기본 정규식을 적용.
//    @Override
//    public void initialize(PhoneNumber constraintAnnotation) {
//        this.regexp = constraintAnnotation.regexp();
//    }
//
//    // validation 실행 시 동작.
//    @Override
//    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        if (s == null || s.isBlank()) {
//            return false; // null 또는 빈 문자열은 유효하지 않음
//        }
//        return Pattern.matches(regexp, s); // 정규식과 입력 문자열을 올바른 순서로
//    }
//
//}
