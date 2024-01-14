package com.romeoscode.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:21
 */
@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the Customer",
            example = "Romeo Jerenyama"
    )
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    private String name;

    @Schema(
            description = "Email of the Customer",
            example = "janedoe@gmail.com"
    )
    @Email(message = "Email should be a valid value")
    @NotEmpty(message = "Email cannot be blank")
    private String email;

    @Schema(
            description = "Mobile number of the Customer",
            example = "0771330379"
    )
    @NotNull(message = "Mobile number cannot be null")
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}
