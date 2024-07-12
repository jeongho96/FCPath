//package com.fc.path.fcpath.validation_part.model;
//
//
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import com.fc.path.fcpath.validation_part.annotation.PhoneNumber;
//import com.fc.path.fcpath.validation_part.annotation.YearMonth;
//import jakarta.validation.constraints.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.util.Objects;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
//public class UserRegisterRequest {
//
////    @NotNull // != null
////    @NotEmpty // != null && name != ""
////    @NotBlank // != null && name != "" && name != " "
//    private String name;
//
//    private String nickName;
//
//    @Size(min = 1, max = 12) // 1 ~ 12자리 필요
//    @NotBlank
//    private String password;
//
//
//    @NotNull
//    @Min(1)
//    @Max(100)
//    private Integer age;
//
//    // Email로 입력받기
//    @Email
//    private String email;
//
//    // 휴대폰번호를 표현하는 정규식
////    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$" , message = "휴대폰 번호 양식이 맞지 않습니다. ")
//    @PhoneNumber
//    private String phoneNumber;
//
//    // 현재 혹은 미래 날짜만 받기.
//    @FutureOrPresent
//    private LocalDateTime registerAt;
//
//    @YearMonth(pattern = "yyyy-MM")
//    private String tempDate;
//
//    @AssertTrue(message = "name or nickName은 반드시 1개 이상 존재해야 합니다.")
//    public boolean nameCheck(){
//
//        if(Objects.nonNull(name) && !name.isBlank()){
//            return true;
//        }
//
//        if(Objects.nonNull(nickName) && !nickName.isBlank()){
//            return true;
//        }
//
//
//        return false;
//    }
//}
