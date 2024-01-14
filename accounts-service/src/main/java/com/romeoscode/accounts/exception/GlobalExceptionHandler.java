package com.romeoscode.accounts.exception;

import com.romeoscode.accounts.dto.ErrorResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 16:00
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest){

        var errorResponseDto = new ErrorResponseDto(webRequest
                .getDescription(false),
                INTERNAL_SERVER_ERROR, exception.getMessage(), now());

        return new ResponseEntity<>(errorResponseDto, INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistException(CustomerAlreadyExistException exception,
                                                                          WebRequest webRequest){

        var errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
                BAD_REQUEST, exception.getMessage(), now());

        return new ResponseEntity<>(errorResponseDto, BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                            WebRequest webRequest){
        var errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
                NOT_FOUND, exception.getMessage(), now());

        return new ResponseEntity<>(errorResponseDto, NOT_FOUND);

    }
}
