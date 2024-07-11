package com.fc.auth_simple.controller;


import com.fc.auth_simple.model.LoginRequest;
import com.fc.auth_simple.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
        @RequestBody
        LoginRequest loginRequest,

        HttpSession httpSession
    ){
        userService.login(loginRequest, httpSession);
    }

}
