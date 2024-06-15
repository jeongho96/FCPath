package me.fc.fcbackendpath.restapi.controller;


import me.fc.fcbackendpath.restapi.model.BookRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {


    @PostMapping("/post-check")
    public String postCheck(@RequestBody BookRequest bookRequest) {
        System.out.println(bookRequest.toString());

        return bookRequest.toString();
    }

}
