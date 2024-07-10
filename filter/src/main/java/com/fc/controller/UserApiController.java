package com.fc.controller;

import com.fc.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {


    @PostMapping("")
    public void register(
//            @RequestBody
//            UserRequest userRequest
            HttpEntity http
    ){

        log.info("{}", http.getBody());
    }
}
