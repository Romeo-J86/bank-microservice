package com.romeoscode.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 14:26
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with the given input data %s : '%s'", resourceName, fieldName,
                fieldValue));
    }
}
