package com.cacheexample.controller;

import com.cacheexample.exception.CustomException;
import com.cacheexample.model.Book;
import com.cacheexample.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Simeon_Markov on 7/14/2017.
 */

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookRepository bookRepository;

    @GetMapping("/{isbn}")
    public Book getISBN(@PathVariable("isbn") String isbn) throws CustomException {
        System.out.println("Getting an ISBN...");
        if(!isbn.contains("isbn")) {
            throw new CustomException("exception thrown here");
        }
        return bookRepository.getByIsbn(isbn);
    }

}
