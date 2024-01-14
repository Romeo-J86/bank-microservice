package com.romeoscode.accounts.api;

import com.romeoscode.accounts.dto.CustomerDto;
import com.romeoscode.accounts.dto.ErrorResponseDto;
import com.romeoscode.accounts.dto.ResponseDto;
import com.romeoscode.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.romeoscode.accounts.constants.Constants.Messages.*;
import static com.romeoscode.accounts.constants.Constants.StatusCodes.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:50
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = {APPLICATION_JSON_VALUE})
@Tag(
        name = "CRUD REST APIs for Accounts",
        description = "CRUD REST APIs to CREATE, FETCH, UPDATE AND DELETE account details"
)
public class AccountsRestController {

    private final IAccountsService iAccountsService;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer and Account"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
        iAccountsService.createAccount(customerDto);

        return ResponseEntity.status(CREATED)
                .body(new ResponseDto(CREATE_STATUS_CODE,
                        ACCOUNTS_CREATED));
    }

    @Operation(
            summary = "Fetch Account REST API",
            description = "REST API to fetch Customer & Account details based on mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status OK"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber){
        var customerDto = iAccountsService.fetchAccount(mobileNumber);

        return ResponseEntity.ok(customerDto);
    }
    @Operation(
            summary = "Update Account Details REST API",
            description = "REST API to update Customer and Account details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Http Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(
                                    implementation = ErrorResponseDto.class
                            )
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto){

        boolean isUpdated = iAccountsService.updateAccount(customerDto);

        if (isUpdated){
            return ResponseEntity.ok(new ResponseDto(OK_STATUS_CODE, RECORD_UPDATED));
        }else {
            return ResponseEntity.internalServerError()
                    .body(new ResponseDto(INTERNAL_ERROR_CODE, INTERNAL_ERROR));
        }
    }
}
