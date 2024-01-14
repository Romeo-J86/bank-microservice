package com.romeoscode.accounts.service;

import com.romeoscode.accounts.dto.CustomerDto;

/**
 * @author romeo.jerenyama
 * @created 02/01/2024 - 18:39
 */
public interface IAccountsService {

    /**
     * Method attempts to create a new account
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
}
