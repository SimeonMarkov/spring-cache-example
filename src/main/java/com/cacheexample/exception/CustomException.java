package com.cacheexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * Created by Simeon_Markov on 7/14/2017.
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request for ISBN")
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
