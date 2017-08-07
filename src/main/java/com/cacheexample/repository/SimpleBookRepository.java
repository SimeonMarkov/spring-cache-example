package com.cacheexample.repository;

import com.cacheexample.exception.CustomException;
import com.cacheexample.model.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * Created by Simeon_Markov on 7/12/2017.
 */

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) throws CustomException {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        try {
            final long time = 3000L;
            System.out.println("Sleeping...");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("something happened here..");
            throw new IllegalStateException(e);
        }
    }
}
