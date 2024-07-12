package com.example.jpa.user.controller;


import com.example.jpa.user.db.UserEntity;
import com.example.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public String findAll() {
        return userRepository.findAll().toString();
    }

    @GetMapping("/{name}")
    public void autoSave(
            @PathVariable String name
    ){
        var user = UserEntity.builder().name(name).build();

        userRepository.save(user);
    }
}
