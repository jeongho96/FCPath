package com.fc.post.controller;


import com.fc.post.db.PostEntity;
import com.fc.post.model.PostRequest;
import com.fc.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;


    @PostMapping("")
    public PostEntity create(
            @Valid
            @RequestBody PostRequest postRequest
    ){
        return postService.create(postRequest);
    }
}
