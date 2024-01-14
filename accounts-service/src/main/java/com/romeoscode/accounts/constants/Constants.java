package com.romeoscode.accounts.constants;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 00:43
 */
public interface Constants {

    interface StatusCodes {
        int CREATE_STATUS_CODE = 201;
        int OK_STATUS_CODE = 200;
        int INTERNAL_ERROR_CODE = 500;
    }

    interface Messages {
        String CUSTOMER_CREATED = "Customer created successfully!";
        String ACCOUNTS_CREATED = "Account created successfully!";
        String RECORD_FOUND = "Record found";
        String RECORD_UPDATED = "Record updated";
        String INTERNAL_ERROR = "An error has occurred please contact the admin";
    }

    interface AccountType {
        String SAVINGS_ACCOUNT = "SAVINGS";
        String CURRENT_ACCOUNT = "CURRENT";
    }
}
