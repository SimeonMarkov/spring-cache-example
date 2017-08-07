package com.cacheexample.repository;

import com.cacheexample.exception.CustomException;
import com.cacheexample.model.Book;

/**
 *
 * Created by Simeon_Markov on 7/12/2017.
 */
public interface BookRepository {

    Book getByIsbn(String isbn) throws CustomException;
}
