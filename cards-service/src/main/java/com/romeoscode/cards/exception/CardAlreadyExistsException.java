package com.romeoscode.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 16:57
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExistsException extends RuntimeException{
    public CardAlreadyExistsException(String message) {
        super(message);
    }
}
