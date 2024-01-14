package com.romeoscode.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:25
 */
@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "Code representing the error occurred"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error message representing the error occurred"
    )
    private String errorMessage;
    @Schema(
            description = "Time representing when the error occurred"
    )
    private LocalDateTime errorTime;
}
