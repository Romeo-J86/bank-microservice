package com.romeoscode.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 14:27
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAlreadyExistsException extends RuntimeException{
    public LoanAlreadyExistsException(String message) {
        super(message);
    }
}
