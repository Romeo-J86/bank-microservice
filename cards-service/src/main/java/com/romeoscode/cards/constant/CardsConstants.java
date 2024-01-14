package com.romeoscode.cards.constant;

/**
 * @author romeo.jerenyama
 * @created 06/01/2024 - 17:03
 */
public interface CardsConstants {

    interface StatusCode{
        String  STATUS_201 = "201";
        String  STATUS_200 = "200";
        String  STATUS_417 = "417";
    }

    interface Message{
        String  MESSAGE_201 = "Card created successfully";

        String  MESSAGE_200 = "Request processed successfully";

        String  MESSAGE_417_UPDATE= "Update operation failed. Please try again or contact Dev team";
        String  MESSAGE_417_DELETE= "Delete operation failed. Please try again or contact Dev team";

    }
   String  CREDIT_CARD = "Credit Card";
    int  NEW_CARD_LIMIT = 1_00_000;


}
