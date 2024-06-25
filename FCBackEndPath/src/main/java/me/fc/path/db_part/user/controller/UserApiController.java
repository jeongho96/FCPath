package me.fc.path.db_part.user.controller;


import lombok.RequiredArgsConstructor;
import me.fc.path.db_part.user.model.UserEntity;
import me.fc.path.db_part.user.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();

    }

    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/min-max")
    public List<UserEntity> filterScore(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.filterScore(min, max);
    }

}
