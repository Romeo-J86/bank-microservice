package com.romeoscode.accounts.mapper;

import com.romeoscode.accounts.domain.Accounts;
import com.romeoscode.accounts.domain.Customer;
import com.romeoscode.accounts.dto.AccountsDto;
import com.romeoscode.accounts.dto.CustomerDto;
import org.springframework.beans.BeanUtils;

/**
 * @author romeo.jerenyama
 * @created 03/01/2024 - 17:27
 */
public class EntityMapper {

    public static CustomerDto buildCustomerDto(Customer customer){
        var customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static void mapToCustomer(CustomerDto customerDto, Customer customer){
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
    }

    public static AccountsDto buildAccountsDto(Accounts accounts){
        var accountsDto = new AccountsDto();
        BeanUtils.copyProperties(accounts, accountsDto);
        return accountsDto;
    }

    public static void mapToAccounts(AccountsDto accountsDto, Accounts accounts){
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
    }

}
