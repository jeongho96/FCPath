package com.fc.controller;

import com.fc.filter.interceptor.OpenApi;
import com.fc.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {


    @OpenApi
    @PostMapping("")
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){

        log.info("{}", userRequest);

        return userRequest;
    }


    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

}
