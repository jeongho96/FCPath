package com.fc.auth_simple.controller;

import com.fc.auth_simple.model.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {


    @GetMapping("/me")
    public UserDto me(
            HttpSession httpSession
    ){
        var userObject = httpSession.getAttribute("user");

        if(userObject != null){
            var userDto = (UserDto) userObject;
            return userDto;
        }else{
            return null;
        }
    }
}
