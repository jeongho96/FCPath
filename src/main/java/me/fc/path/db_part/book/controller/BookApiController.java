package me.fc.path.db_part.book.controller;


import lombok.RequiredArgsConstructor;
import me.fc.path.db_part.book.db.BookEntity;
import me.fc.path.db_part.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;


    @PostMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll(

    ){
        return bookService.findAll();
    }

}