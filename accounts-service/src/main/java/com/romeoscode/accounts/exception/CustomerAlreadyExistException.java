package com.romeoscode.accounts.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 14:51
 */
@ResponseStatus(BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException{
    public CustomerAlreadyExistException(String message) {
        super(message);
    }
}
