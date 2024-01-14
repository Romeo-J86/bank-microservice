package com.romeoscode.accounts.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 16:58
 */
@ResponseStatus(NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(format("%s not found with the given input data %s : '%s' ", resourceName, fieldName, fieldValue));
    }
}
