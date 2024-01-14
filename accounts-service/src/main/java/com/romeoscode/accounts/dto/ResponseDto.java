package com.romeoscode.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:23
 */
@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)

public class ResponseDto {

    @Schema(
            description = "Response status code",
            example = "200"
    )
    private int statusCode;

    @Schema(
            description = "Response status message",
            example = "Request processed successfully"
    )
    private String statusMessage;
}
