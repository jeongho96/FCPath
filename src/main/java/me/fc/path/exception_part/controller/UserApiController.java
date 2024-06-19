package me.fc.path.exception_part.controller;


import com.fc.path.fcpath.exception_part.model.Api;
import com.fc.path.fcpath.exception_part.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@RestController
//@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(20)
                    .name("유관순")
                    .build()
    );

//    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        var user = userList.stream().filter(
                u -> u.getId().equals(userId)
        )
                .findFirst()
                .get();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;

    }
}
