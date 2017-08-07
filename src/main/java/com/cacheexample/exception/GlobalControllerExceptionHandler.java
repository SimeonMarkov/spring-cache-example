package com.cacheexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

/**
 *
 * Created by Simeon_Markov on 7/14/2017.
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ResponseBody
    @ExceptionHandler({CustomException.class})
    ExceptionRepresentation handle(Exception exception) {
        ExceptionRepresentation body = new ExceptionRepresentation(exception.getLocalizedMessage());
        HttpStatus responseStatus = resolveAnnotatedResponseStatus(exception);
        return body;
    }

    HttpStatus resolveAnnotatedResponseStatus(Exception exception) {
        ResponseStatus annotation = findMergedAnnotation(exception.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
