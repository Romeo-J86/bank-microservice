package com.romeoscode.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 16:50
 */
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
@Data @AllArgsConstructor
public class ResponseDto {

    @Schema(
            description = "Status code in the response"
    )
    private String statusCode;

    @Schema(
            description = "Status message in the response"
    )
    private String statusMsg;
}
