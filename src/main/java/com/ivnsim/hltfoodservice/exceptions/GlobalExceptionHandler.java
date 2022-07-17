package com.ivnsim.hltfoodservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {FoodNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage foodNotFoundException(FoodNotFoundException foodNotFoundException, HttpServletRequest httpServletRequest) {
        return new ErrorMessage(
                Timestamp.from(Instant.now()),
                HttpStatus.NOT_FOUND.value(),
                foodNotFoundException.getMessage(),
                httpServletRequest.getRequestURI());
    }

}
