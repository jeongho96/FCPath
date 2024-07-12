package me.fc.path.db_part.book.service;


import me.fc.path.db_part.book.db.BookEntity;
import me.fc.path.db_part.book.db.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    // create , update
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    // all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    // delete

    // find one
}