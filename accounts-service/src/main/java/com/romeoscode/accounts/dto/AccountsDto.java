package com.romeoscode.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:18
 */
@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "Bank Account number"
    )
    @NotEmpty(message = "Account number cannot be empty or null")
    @Pattern(regexp = "([0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "AccountType cannot be empty or null")
    @Schema(
            description = "Account type",
            example = "Current"
    )
    private String accountType;

    @NotEmpty(message = "Branch address cannot be empty or null")
    @Schema(
            description = "Branch address",
            example = "124 Oak Street"
    )
    private String branchAddress;
}
