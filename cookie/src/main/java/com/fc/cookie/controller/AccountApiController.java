package com.fc.cookie.controller;



import com.fc.cookie.model.LoginRequest;
import com.fc.cookie.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        userService.login(loginRequest, httpServletResponse);
    }
}