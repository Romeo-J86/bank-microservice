package com.romeoscode.loans.constants;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 15:21
 */
public interface LoansConstants {

    interface StatusCode{
        String  STATUS_201 = "201";
        String  STATUS_200 = "200";
    }

    interface Message{
        String  MESSAGE_201 = "Loan created successfully";
        String  MESSAGE_200 = "Request processed successfully";String  STATUS_417 = "417";
        String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
        String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";
    }
    String  HOME_LOAN = "Home Loan";
    int  NEW_LOAN_LIMIT = 1_00_000;

}
